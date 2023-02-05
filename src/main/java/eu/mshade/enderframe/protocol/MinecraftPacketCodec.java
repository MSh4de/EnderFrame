package eu.mshade.enderframe.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MinecraftPacketCodec extends MessageToMessageCodec<ByteBuf, MinecraftPacketOut> {

    private static Logger LOGGER = LoggerFactory.getLogger(MinecraftPacketCodec.class);


    @Override
    protected void encode(ChannelHandlerContext ctx, MinecraftPacketOut msg, List<Object> out) throws Exception {
        ByteBuf buffer = ctx.alloc().buffer();
        Channel channel = ctx.channel();
        MinecraftProtocolPipeline minecraftProtocolPipeline = MinecraftProtocolPipeline.get();

        MinecraftSession minecraftSession = minecraftProtocolPipeline.getMinecraftSession(channel);
        MinecraftProtocol minecraftProtocol = minecraftProtocolPipeline.getProtocol(channel);
        MinecraftByteBuf minecraftByteBuf = minecraftProtocol.getProtocolBuffer(buffer);

        int id = minecraftProtocol.getProtocolRegistry().getPacketID(minecraftSession.getProtocolStatus(), msg);
        if (id == -1) {
            LOGGER.error("Undefined outgoing packet of class {}", msg.getClass());
            return;
        }

        minecraftByteBuf.writeVarInt(id);
        msg.serialize(minecraftByteBuf);
        out.add(buffer);

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (!ctx.channel().isActive()) return;
        Channel channel = ctx.channel();
        MinecraftProtocolPipeline minecraftProtocolPipeline = MinecraftProtocolPipeline.get();

        MinecraftSession minecraftSession = minecraftProtocolPipeline.getMinecraftSession(channel);
        MinecraftProtocol minecraftProtocol = minecraftProtocolPipeline.getProtocol(channel);
        MinecraftByteBuf minecraftByteBuf = minecraftProtocol.getProtocolBuffer(msg);

        int packetId = minecraftByteBuf.readVarInt();

        MinecraftPacketIn packetByID = minecraftProtocol.getProtocolRegistry().getPacketByID(minecraftSession.getProtocolStatus(), packetId);
        if (packetByID != null) {
            packetByID.deserialize(minecraftSession, minecraftByteBuf);
            out.add(packetByID);
        } else {
            LOGGER.info("Undefined incoming packet of id {}", packetId);
        }


    }

}
