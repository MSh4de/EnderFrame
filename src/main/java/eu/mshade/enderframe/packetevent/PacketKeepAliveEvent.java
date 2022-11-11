package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class PacketKeepAliveEvent implements PacketEvent {

    private MinecraftSession minecraftSession;
    private final int threshold;

    public PacketKeepAliveEvent(MinecraftSession minecraftSession, int threshold) {
        this.threshold = threshold;
        this.minecraftSession = minecraftSession;
    }

    public int getThreshold() {
        return threshold;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
