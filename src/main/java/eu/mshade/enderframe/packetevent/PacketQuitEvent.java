package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSession;

public class PacketQuitEvent implements PacketEvent {

    private EnderFrameSession enderFrameSession;
    public PacketQuitEvent(EnderFrameSession enderFrameSession) {
        this.enderFrameSession = enderFrameSession;
    }

    public EnderFrameSession getEnderFrameSession() {
        return enderFrameSession;
    }
}
