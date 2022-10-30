package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.Handshake;

public class PacketHandshakeEvent implements PacketEvent {

    private final Handshake handshake;

    public PacketHandshakeEvent(Handshake handshake) {
        this.handshake = handshake;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    @Override
    public String toString() {
        return "HandshakeEvent{" +
                "handshake=" + handshake +
                '}';
    }
}
