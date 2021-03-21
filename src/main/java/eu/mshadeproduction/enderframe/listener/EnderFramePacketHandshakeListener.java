package eu.mshadeproduction.enderframe.listener;

import eu.mshadeproduction.enderframe.EnderFrame;
import eu.mshadeproduction.enderframe.EnderFrameBridge;
import eu.mshadeproduction.enderframe.event.player.HandshakeEvent;
import eu.mshadeproduction.enderframe.protocol.packet.EnderFramePacketInHandshake;
import eu.mshadeproduction.mwork.dispatcher.DispatcherContainer;
import eu.mshadeproduction.mwork.dispatcher.DispatcherListener;

import java.net.InetSocketAddress;

public class EnderFramePacketHandshakeListener implements DispatcherListener<EnderFramePacketInHandshake> {

    @Override
    public void handle(EnderFramePacketInHandshake packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getEventDispatcherDriver().dispatch(new HandshakeEvent(packet.getVersion(), InetSocketAddress.createUnresolved(packet.getHost(), packet.getPort()), packet.getHandshakeStatus()), dispatcherContainer);
    }

}
