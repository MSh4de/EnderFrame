package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketServerPingEvent implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;
    private final long payload;

    public MinecraftPacketServerPingEvent(MinecraftSession minecraftSession, long payload) {
        this.payload = payload;
        this.minecraftSession = minecraftSession;
    }
    public long getPayload() {
        return payload;
    }

    public MinecraftSession getMinecraftSession() {
        return minecraftSession;
    }

    @Override
    public String toString() {
        return "ServerPingEvent{" +
                "payload=" + payload +
                '}';
    }
}
