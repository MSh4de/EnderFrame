package eu.mshadeproduction.enderframe.listener;

import eu.mshadeproduction.enderframe.EnderFrame;
import eu.mshadeproduction.enderframe.protocol.packet.EnderFramePacketInPing;
import eu.mshadeproduction.mwork.dispatcher.DispatcherContainer;
import eu.mshadeproduction.mwork.dispatcher.DispatcherListener;

public class EnderFramePacketPingListener implements DispatcherListener<EnderFramePacketInPing> {

    @Override
    public void handle(EnderFramePacketInPing packet, DispatcherContainer dispatcherContainer) {
        EnderFrame.get().getEventDispatcherDriver().dispatch(new ServerPingEvent(packet.getPayload()), dispatcherContainer);
    }
}
