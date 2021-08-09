package eu.mshade.enderframe.protocol.temp.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.server.ServerPingEvent;
import eu.mshade.enderframe.protocol.temp.packet.PacketInPing;
import eu.mshade.mwork.event.ParameterContainer;
import eu.mshade.mwork.event.EventListener;

public class PacketPingListener implements EventListener<PacketInPing> {

    @Override
    public void onEvent(PacketInPing event, ParameterContainer eventContainer) {
        EnderFrame.get().getPacketEventBus().publish(new ServerPingEvent(event.getPayload()), eventContainer);
    }

    /*
    @Override
    public void handle(PacketInPing packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getPacketEventBus().dispatch(new ServerPingEvent(packet.getPayload()), dispatcherContainer);
    }

     */
}
