package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftHandshake;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketHandshakeEvent implements MinecraftPacketEvent {

    private final MinecraftHandshake minecraftHandshake;
    private final MinecraftSession minecraftSession;

    public MinecraftPacketHandshakeEvent(MinecraftSession minecraftSession, MinecraftHandshake minecraftHandshake) {
        this.minecraftHandshake = minecraftHandshake;
        this.minecraftSession = minecraftSession;
    }

    public MinecraftHandshake getHandshake() {
        return minecraftHandshake;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

    @Override
    public String toString() {
        return "HandshakeEvent{" +
                "handshake=" + minecraftHandshake +
                '}';
    }
}
