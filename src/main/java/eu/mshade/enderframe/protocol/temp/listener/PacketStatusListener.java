package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.ServerStatusEvent;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInStatus;
import eu.mshade.mwork.event.EventListener;

public class PacketStatusListener implements EventListener<MinecraftPacketInStatus> {
    @Override
    public void onEvent(MinecraftPacketInStatus event) {
        EnderFrame.get().getPacketEventBus().publish(new ServerStatusEvent(event.getSessionWrapper()));
    }

    /*
    @Override
    public void handle(PacketInStatus packetInStatus, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getPacketEventBus().dispatch(new ServerStatusEvent(), dispatcherContainer);
    }

     */

}
