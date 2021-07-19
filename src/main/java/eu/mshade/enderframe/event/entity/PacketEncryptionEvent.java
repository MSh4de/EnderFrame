package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;

public class PacketEncryptionEvent implements PacketEvent {

    private byte[] sharedSecret;
    private byte[] verifyToken;

    public PacketEncryptionEvent(byte[] sharedSecret, byte[] verifyToken) {
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public byte[] getSharedSecret() {
        return sharedSecret;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }
}
