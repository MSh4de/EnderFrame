package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.SessionWrapper;

public class PacketEncryptionEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;
    private final byte[] sharedSecret;
    private final byte[] verifyToken;

    public PacketEncryptionEvent(SessionWrapper sessionWrapper, byte[] sharedSecret, byte[] verifyToken) {
        this.sessionWrapper = sessionWrapper;
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }

    public byte[] getSharedSecret() {
        return sharedSecret;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }
}
