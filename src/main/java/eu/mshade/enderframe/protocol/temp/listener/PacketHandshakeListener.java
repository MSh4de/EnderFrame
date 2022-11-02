package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.PacketHandshakeEvent;
import eu.mshade.enderframe.protocol.Handshake;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInHandshake;
import eu.mshade.mwork.event.EventListener;

import java.net.InetSocketAddress;

public class PacketHandshakeListener implements EventListener<MinecraftPacketInHandshake> {

    @Override
    public void onEvent(MinecraftPacketInHandshake event) {
        Handshake handshake = new Handshake(event.getVersion(), InetSocketAddress.createUnresolved(event.getHost(), event.getPort()), event.getHandshakeStatus());
        EnderFrame.get().getPacketEventBus().publish(new PacketHandshakeEvent(event.getSessionWrapper(), handshake));
    }

}
