package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;

public class PacketKeepAliveEvent implements PacketEvent {

    private final int threshold;

    public PacketKeepAliveEvent(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }
}
