package eu.mshadeproduction.enderframe.listener;

import eu.mshadeproduction.enderframe.EnderFrame;
import eu.mshadeproduction.enderframe.event.server.ServerStatusEvent;
import eu.mshadeproduction.enderframe.protocol.packet.EnderFramePacketInStatus;
import eu.mshadeproduction.mwork.dispatcher.DispatcherContainer;
import eu.mshadeproduction.mwork.dispatcher.DispatcherListener;

public class EnderFramePacketStatusListener implements DispatcherListener<EnderFramePacketInStatus> {

    @Override
    public void handle(EnderFramePacketInStatus enderFramePacketInStatus, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getEventDispatcherDriver().dispatch(new ServerStatusEvent(), dispatcherContainer);
    }

}
