package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.protocol.Handshake;

public class PacketHandshakeEvent implements PacketEvent {

    private final EnderFrameSessionHandler enderFrameSessionHandler;
    private final Handshake handshake;

    public PacketHandshakeEvent(EnderFrameSessionHandler enderFrameSessionHandler, Handshake handshake) {
        this.enderFrameSessionHandler = enderFrameSessionHandler;
        this.handshake = handshake;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
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
