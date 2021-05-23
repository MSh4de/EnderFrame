package eu.mshade.enderframe.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.server.ServerPingEvent;
import eu.mshade.enderframe.protocol.packet.PacketInPing;
import eu.mshade.mwork.dispatcher.DispatcherContainer;
import eu.mshade.mwork.dispatcher.DispatcherListener;

public class PacketPingListener implements DispatcherListener<PacketInPing> {

    @Override
    public void handle(PacketInPing packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getEventDispatcherDriver().dispatch(new ServerPingEvent(packet.getPayload()), dispatcherContainer);
    }
}
