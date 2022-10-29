package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.packetevent.ServerPingEvent;
import eu.mshade.enderframe.protocol.temp.packet.PacketInPing;
import eu.mshade.mwork.ParameterContainer;
import eu.mshade.mwork.event.EventListener;

public class PacketPingListener implements EventListener<PacketInPing> {

    @Override
    public void onEvent(PacketInPing event) {
        EnderFrame.get().getPacketEventBus().publish(new ServerPingEvent(event.getSessionWrapper(), event.getPayload()));
    }

    /*
    @Override
    public void handle(PacketInPing packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getPacketEventBus().dispatch(new ServerPingEvent(packet.getPayload()), dispatcherContainer);
    }

     */
}
