package eu.mshade.enderframe.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.player.HandshakeEvent;
import eu.mshade.enderframe.protocol.Handshake;
import eu.mshade.enderframe.protocol.packet.PacketInHandshake;
import eu.mshade.mwork.dispatcher.DispatcherContainer;
import eu.mshade.mwork.dispatcher.DispatcherListener;

import java.net.InetSocketAddress;

public class PacketHandshakeListener implements DispatcherListener<PacketInHandshake> {

    @Override
    public void handle(PacketInHandshake packet, DispatcherContainer dispatcherContainer) {
        Handshake handshake = new Handshake(packet.getVersion(), InetSocketAddress.createUnresolved(packet.getHost(), packet.getPort()), packet.getHandshakeStatus());
        EnderFrame.get().getEventDispatcherDriver().dispatch(new HandshakeEvent(handshake), dispatcherContainer);
    }

}
