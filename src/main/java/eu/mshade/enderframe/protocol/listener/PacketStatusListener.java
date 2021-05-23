package eu.mshade.enderframe.listener;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.event.server.ServerStatusEvent;
import eu.mshade.enderframe.protocol.packet.PacketInStatus;
import eu.mshade.mwork.dispatcher.DispatcherContainer;
import eu.mshade.mwork.dispatcher.DispatcherListener;

public class PacketStatusListener implements DispatcherListener<PacketInStatus> {

    @Override
    public void handle(PacketInStatus packetInStatus, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getEventDispatcherDriver().dispatch(new ServerStatusEvent(), dispatcherContainer);
    }

}
