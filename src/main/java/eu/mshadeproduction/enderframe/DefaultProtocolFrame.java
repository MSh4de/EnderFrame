package eu.mshadeproduction.enderframe;

import eu.mshadeproduction.enderframe.listener.EnderFramePacketHandshakeListener;
import eu.mshadeproduction.enderframe.listener.EnderFramePacketPingListener;
import eu.mshadeproduction.enderframe.listener.EnderFramePacketStatusListener;
import eu.mshadeproduction.enderframe.protocol.*;
import eu.mshadeproduction.enderframe.protocol.packet.*;
import eu.mshadeproduction.mwork.dispatcher.DefaultDispatcherDriver;
import eu.mshadeproduction.mwork.dispatcher.DispatcherDriver;
import io.netty.buffer.ByteBuf;

public class DefaultProtocolFrame extends ProtocolFrame {

    private final ProtocolRegistry protocolRegistry = new ProtocolRegistry();
    private final DispatcherDriver<PacketIn> packetInDispatcherDriver = new DefaultDispatcherDriver<>();

    public DefaultProtocolFrame() {

        packetInDispatcherDriver.register(EnderFramePacketInHandshake.class, new EnderFramePacketHandshakeListener());
        packetInDispatcherDriver.register(EnderFramePacketInStatus.class, new EnderFramePacketStatusListener());
        packetInDispatcherDriver.register(EnderFramePacketInPing.class, new EnderFramePacketPingListener());

        protocolRegistry.registerIn(ProtocolStatus.HANDSHAKE, 0x00, EnderFramePacketInHandshake.class);

        protocolRegistry.registerOut(ProtocolStatus.STATUS, 0x00, EnderFramePacketOutStatus.class);
        protocolRegistry.registerOut(ProtocolStatus.STATUS, 0x01, EnderFramePacketOutPong.class);

        protocolRegistry.registerIn(ProtocolStatus.STATUS, 0x00, EnderFramePacketInStatus.class);
        protocolRegistry.registerIn(ProtocolStatus.STATUS, 0x01, EnderFramePacketInPing.class);

    }

    @Override
    public ByteMessage getByteMessage(ByteBuf byteBuf) {
        return new DefaultByteMessage(byteBuf);
    }

    @Override
    public ProtocolRegistry getProtocolRegistry() {
        return protocolRegistry;
    }

    @Override
    public DispatcherDriver<PacketIn> getDispatcherDriver() {
        return packetInDispatcherDriver;
    }


}
