package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.MinecraftPacketServerPingEvent;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInServerPing;
import eu.mshade.mwork.event.EventListener;

public class MinecraftPacketServerPingListener implements EventListener<MinecraftPacketInServerPing> {

    @Override
    public void onEvent(MinecraftPacketInServerPing event) {
        EnderFrame.get().getPacketEventBus().publish(new MinecraftPacketServerPingEvent(event.getMinecraftSession(), event.getPayload()));
    }

}
