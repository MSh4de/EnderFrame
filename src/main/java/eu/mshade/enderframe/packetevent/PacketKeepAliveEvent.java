package eu.mshade.enderframe.packetevent;

public class PacketKeepAliveEvent implements PacketEvent {

    private final int threshold;

    public PacketKeepAliveEvent(int threshold) {
        this.threshold = threshold;
    }

    public int getThreshold() {
        return threshold;
    }
}
