package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.ServerPingEventMinecraft;
import eu.mshade.enderframe.protocol.temp.packet.MinecraftPacketInPing;
import eu.mshade.mwork.event.EventListener;

public class PacketPingListener implements EventListener<MinecraftPacketInPing> {

    @Override
    public void onEvent(MinecraftPacketInPing event) {
        EnderFrame.get().getPacketEventBus().publish(new ServerPingEventMinecraft(event.getSessionWrapper(), event.getPayload()));
    }

    /*
    @Override
    public void handle(PacketInPing packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getPacketEventBus().dispatch(new ServerPingEvent(packet.getPayload()), dispatcherContainer);
    }

     */
}
