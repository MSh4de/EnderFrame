package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.MinecraftPacketHandshakeEvent;
import eu.mshade.enderframe.protocol.MinecraftHandshake;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInHandshake;
import eu.mshade.mwork.event.EventListener;

import java.net.InetSocketAddress;

public class MinecraftPacketHandshakeListener implements EventListener<MinecraftPacketInHandshake> {

    @Override
    public void onEvent(MinecraftPacketInHandshake event) {
        MinecraftHandshake minecraftHandshake = new MinecraftHandshake(event.getVersion(), InetSocketAddress.createUnresolved(event.getHost(), event.getPort()), event.getHandshakeStatus());
        EnderFrame.get().getPacketEventBus().publish(new MinecraftPacketHandshakeEvent(event.getMinecraftSession(), minecraftHandshake));
    }

}
