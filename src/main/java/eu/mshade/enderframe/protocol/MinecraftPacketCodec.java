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
        ProtocolPipeline protocolPipeline = ProtocolPipeline.get();

        MinecraftSession minecraftSession = protocolPipeline.getSessionWrapper(channel);
        Protocol protocol = protocolPipeline.getProtocol(channel);
        ProtocolBuffer protocolBuffer = protocol.getProtocolBuffer(buffer);

        int id = protocol.getProtocolRegistry().getPacketID(minecraftSession.getProtocolStatus(), msg);
        if (id == -1) {
            LOGGER.error("Undefined outgoing packet of class {}", msg.getClass());
            return;
        }

        protocolBuffer.writeVarInt(id);
        msg.serialize(protocolBuffer);
        out.add(buffer);

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        if (!ctx.channel().isActive()) return;
        Channel channel = ctx.channel();
        ProtocolPipeline protocolPipeline = ProtocolPipeline.get();

        MinecraftSession minecraftSession = protocolPipeline.getSessionWrapper(channel);
        Protocol protocol = protocolPipeline.getProtocol(channel);
        ProtocolBuffer protocolBuffer = protocol.getProtocolBuffer(msg);

        int packetId = protocolBuffer.readVarInt();

        MinecraftPacketIn packetByID = protocol.getProtocolRegistry().getPacketByID(minecraftSession.getProtocolStatus(), packetId);
        if (packetByID != null) {
            packetByID.deserialize(minecraftSession, protocolBuffer);
            out.add(packetByID);
        } else {
            LOGGER.info("Undefined incoming packet of id {}", packetId);
        }


    }

}
