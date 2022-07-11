package eu.mshade.enderframe.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PacketCodec extends MessageToMessageCodec<ByteBuf, PacketOut> {

    private static Logger logger = LoggerFactory.getLogger(PacketCodec.class);


    @Override
    protected void encode(ChannelHandlerContext ctx, PacketOut msg, List<Object> out) throws Exception {
        ByteBuf buffer  = ctx.alloc().buffer();
        Channel channel = ctx.channel();
        ProtocolPipeline protocolPipeline = ProtocolPipeline.get();

        SessionWrapper sessionWrapper = protocolPipeline.getSessionWrapper(channel);
        Protocol protocol = protocolPipeline.getProtocol(channel);
        ProtocolBuffer protocolBuffer = protocol.getProtocolBuffer(buffer);

        protocol.getProtocolRegistry().getPacketID(sessionWrapper.getProtocolStatus(), msg).exception(e -> logger.error("",e)).ifPresent(integer -> {
            protocolBuffer.writeVarInt(integer);
            msg.serialize(protocolBuffer);
            out.add(buffer);
        }).ifNotPresent(unused -> {
            logger.info(String.format("Undefined outgoing packet of class %s", msg.getClass().getName()));
        });

    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
            if (!ctx.channel().isActive()) return;
            Channel channel = ctx.channel();
            ProtocolPipeline protocolPipeline = ProtocolPipeline.get();

            SessionWrapper sessionWrapper = protocolPipeline.getSessionWrapper(channel);
            Protocol protocol = protocolPipeline.getProtocol(channel);
            ProtocolBuffer protocolBuffer = protocol.getProtocolBuffer(msg);

            int packetId = protocolBuffer.readVarInt();

            protocol.getProtocolRegistry().getPacketByID(sessionWrapper.getProtocolStatus(), packetId).ifPresent(packetIn -> {
                packetIn.deserialize(protocolBuffer);
                out.add(packetIn);
            }).ifNotPresent(unused -> {
                logger.info(String.format("Undefined incoming packet: %s", packetId));
            });

    }

}
