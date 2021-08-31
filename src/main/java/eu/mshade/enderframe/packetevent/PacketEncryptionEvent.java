package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class PacketEncryptionEvent implements PacketEvent {

    private final Player player;
    private final byte[] sharedSecret;
    private final byte[] verifyToken;

    public PacketEncryptionEvent(Player player, byte[] sharedSecret, byte[] verifyToken) {
        this.player = player;
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public byte[] getSharedSecret() {
        return sharedSecret;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }

    public Player getPlayer() {
        return player;
    }
}
