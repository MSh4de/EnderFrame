package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;
import eu.mshade.enderframe.protocol.Handshake;

public class PacketHandshakeEvent implements PacketEvent {

    private Handshake handshake;

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
