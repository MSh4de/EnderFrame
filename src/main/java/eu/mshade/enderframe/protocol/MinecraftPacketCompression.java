package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.protocol.temp.TempMinecraftProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class MinecraftPacketCompression extends MessageToMessageCodec<ByteBuf, ByteBuf> {

    private final int threshold;
    private final Inflater inflater = new Inflater();
    private final byte[] buffer = new byte[8192];
    private final Deflater deflater = new Deflater();
    private final MinecraftProtocol minecraftProtocol = TempMinecraftProtocol.Companion.getINSTANCE();

    /**
     * Creates an instance that compresses messages using an {@link Inflater} and {@link Deflater}.
     *
     * @param threshold the smallest message length, in bytes, to compress
     */
    public MinecraftPacketCompression(int threshold) {
        this.threshold = threshold;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out)
            throws Exception {
        int i = byteBuf.readableBytes();
        ByteBuf buffer = ctx.alloc().buffer();
        MinecraftByteBuf minecraftByteBuf = minecraftProtocol.getProtocolBuffer(buffer);

        if (i < threshold) {
            minecraftByteBuf.writeVarInt(0);
            buffer.writeBytes(byteBuf);
        } else {
            byte[] abyte = new byte[i];
            byteBuf.readBytes(abyte);
            minecraftByteBuf.writeVarInt(abyte.length);
            this.deflater.setInput(abyte, 0, i);
            this.deflater.finish();

            while (!this.deflater.finished()) {
                int j = this.deflater.deflate(this.buffer);

                buffer.writeBytes(this.buffer, 0, j);
            }

            this.deflater.reset();
        }

        out.add(buffer);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> out)
            throws Exception {
        MinecraftByteBuf minecraftByteBuf = minecraftProtocol.getProtocolBuffer(byteBuf);
        if (byteBuf.readableBytes() != 0) {
            int i = minecraftByteBuf.readVarInt();
            if (i == 0) {
                out.add(byteBuf.readBytes(byteBuf.readableBytes()));
            } else {
                if (i < threshold) {
                    throw new DecoderException("Badly compressed packet - size of " + i + " is below server threshold of " + this.threshold);
                }

                if (i > 2097152) {
                    throw new DecoderException("Badly compressed packet - size of " + i + " is larger than protocol maximum of " + 2097152);
                }

                byte[] abyte = new byte[byteBuf.readableBytes()];

                byteBuf.readBytes(abyte);
                this.inflater.setInput(abyte);
                byte[] abyte1 = new byte[i];

                this.inflater.inflate(abyte1);
                out.add(Unpooled.wrappedBuffer(abyte1));
                this.inflater.reset();
            }

        }
    }
}
