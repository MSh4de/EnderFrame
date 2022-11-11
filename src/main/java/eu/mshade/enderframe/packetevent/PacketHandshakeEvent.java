package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftHandshake;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class PacketHandshakeEvent implements PacketEvent {

    private final MinecraftHandshake minecraftHandshake;
    private final MinecraftSession minecraftSession;

    public PacketHandshakeEvent(MinecraftSession minecraftSession, MinecraftHandshake minecraftHandshake) {
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
