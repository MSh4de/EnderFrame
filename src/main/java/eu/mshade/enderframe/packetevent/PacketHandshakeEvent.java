package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.protocol.Handshake;

public class PacketHandshakeEvent implements PacketEvent {

    private final Player player;
    private final Handshake handshake;

    public PacketHandshakeEvent(Player player, Handshake handshake) {
        this.player = player;
        this.handshake = handshake;
    }

    public Player getPlayer() {
        return player;
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
