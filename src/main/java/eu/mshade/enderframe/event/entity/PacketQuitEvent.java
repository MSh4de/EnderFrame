package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.event.PacketEvent;

public class PacketQuitEvent implements PacketEvent {

    private EnderFrameSession enderFrameSession;
    public PacketQuitEvent(EnderFrameSession enderFrameSession) {
        this.enderFrameSession = enderFrameSession;
    }

    public EnderFrameSession getEnderFrameSession() {
        return enderFrameSession;
    }
}
