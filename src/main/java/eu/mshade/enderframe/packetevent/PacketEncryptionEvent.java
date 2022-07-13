package eu.mshade.enderframe.packetevent;


public class PacketEncryptionEvent implements PacketEvent {

    private final byte[] sharedSecret;
    private final byte[] verifyToken;

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
