package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.Handshake;
import eu.mshade.enderframe.protocol.SessionWrapper;

public class PacketHandshakeEvent implements PacketEvent {

    private final Handshake handshake;
    private final SessionWrapper sessionWrapper;

    public PacketHandshakeEvent(SessionWrapper sessionWrapper, Handshake handshake) {
        this.handshake = handshake;
        this.sessionWrapper = sessionWrapper;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }

    @Override
    public String toString() {
        return "HandshakeEvent{" +
                "handshake=" + handshake +
                '}';
    }
}
