package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.EnderFrameProtocol;
import eu.mshade.enderframe.protocol.temp.TempEnderFrameProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PacketCodec extends MessageToMessageCodec<ByteBuf, PacketOut> {

    private EnderFrameProtocol enderFrameProtocol = new TempEnderFrameProtocol();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;
    private static Logger logger = LoggerFactory.getLogger(PacketCodec.class);


    @Override
    protected void encode(ChannelHandlerContext ctx, PacketOut msg, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        ByteMessage buf = enderFrameProtocol.getByteMessage(buffer);
        enderFrameProtocol.getProtocolRegistry().getPacketID(protocolStatus, msg).ifPresent(integer -> {
            buf.writeVarInt(integer);
            msg.serialize(buf);
            out.add(buffer);
        }).ifNotPresent(unused -> {
            logger.info(String.format("Undefined outgoing packet of class %s", msg.getClass().getName()));
            //logger.log(Level.WARNING, String.format("Undefined packetID class: %s", msg.getClass().getName()))
        });
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (!ctx.channel().isActive()) return;
        ByteMessage buf = enderFrameProtocol.getByteMessage(msg);
        int packetId = buf.readVarInt();
        enderFrameProtocol.getProtocolRegistry().getPacketByID(protocolStatus, packetId).ifPresent(packetIn -> {
            packetIn.deserialize(buf);
            ctx.fireChannelRead(packetIn);
        }).ifNotPresent(unused -> {
            logger.info(String.format("Undefined incoming packet: %s", packetId));
            //logger.log(Level.WARNING, String.format("Undefined incoming packet: %s", packetId))
        });

    }

    public void toggleProtocolFrame(EnderFrameProtocol enderFrameProtocol){
        this.enderFrameProtocol = enderFrameProtocol;
    }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
    }

}
