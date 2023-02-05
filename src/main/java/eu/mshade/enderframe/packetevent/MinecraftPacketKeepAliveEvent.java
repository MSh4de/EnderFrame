package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketKeepAliveEvent implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;
    private final int threshold;

    public MinecraftPacketKeepAliveEvent(MinecraftSession minecraftSession, int threshold) {
        this.threshold = threshold;
        this.minecraftSession = minecraftSession;
    }

    public int getThreshold() {
        return threshold;
    }

    public MinecraftSession getMinecraftSession() {
        return minecraftSession;
    }
}
