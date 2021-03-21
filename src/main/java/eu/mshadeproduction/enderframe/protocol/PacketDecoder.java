package eu.mshadeproduction.enderframe.protocol;

import eu.mshadeproduction.enderframe.DefaultProtocolFrame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PacketDecoder extends MessageToMessageDecoder<ByteBuf> {

    private static final Logger logger = LoggerFactory.getLogger("");
    private ProtocolFrame protocolFrame = new DefaultProtocolFrame();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buf, List<Object> out) throws Exception {
        if (!ctx.channel().isActive()) return;

        ByteMessage msg = protocolFrame.getByteMessage(buf);
        int packetId = msg.readVarInt();
        protocolFrame.getProtocolRegistry().getPacketByID(protocolStatus, packetId).ifPresent(packetIn -> {
            try {
                packetIn.deserialize(msg);
            } catch (Exception e) {
                logger.warn(String.format("Cannot decode packet %s: ", packetId)/*, e*/);
            }

            ctx.fireChannelRead(packetIn);
        }).ifNotPresent(() -> logger.warn(String.format("Undefined incoming packet: %s", packetId)));
    }


    public void toggleProtocolFrame(ProtocolFrame protocolFrame){
        this.protocolFrame = protocolFrame;
    }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
    }

}
