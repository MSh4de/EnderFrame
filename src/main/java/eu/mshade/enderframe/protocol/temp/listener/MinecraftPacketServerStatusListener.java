package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.MinecraftPacketServerStatusEvent;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInServerStatus;
import eu.mshade.mwork.event.EventListener;

public class MinecraftPacketServerStatusListener implements EventListener<MinecraftPacketInServerStatus> {
    @Override
    public void onEvent(MinecraftPacketInServerStatus event) {
        EnderFrame.get().getPacketEvents().publish(new MinecraftPacketServerStatusEvent(event.getMinecraftSession()));
    }

}
