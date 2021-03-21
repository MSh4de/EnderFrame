package eu.mshadeproduction.enderframe.protocol;

import eu.mshadeproduction.enderframe.DefaultProtocolFrame;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketEncoder extends MessageToByteEncoder<PacketOut> {

    private static final Logger logger = LoggerFactory.getLogger("");

    private ProtocolFrame protocolFrame = new DefaultProtocolFrame();
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;


    @Override
    protected void encode(ChannelHandlerContext ctx, PacketOut packet, ByteBuf out) throws Exception {
        ByteMessage msg = protocolFrame.getByteMessage(out);
        protocolFrame.getProtocolRegistry().getPacketID(protocolStatus, packet).ifPresent(integer -> {
            msg.writeVarInt(integer);
            packet.serialize(msg);
        }).ifNotPresent(() -> logger.warn(String.format("Undefined packetID class: %s", packet.getClass().getName())));
    }

    public void toggleProtocolFrame(ProtocolFrame protocolFrame){
        this.protocolFrame = protocolFrame;
    }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
    }

}
