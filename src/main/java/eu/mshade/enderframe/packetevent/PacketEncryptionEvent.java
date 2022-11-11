package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.MinecraftSession;

public class PacketEncryptionEvent implements PacketEvent {

    private MinecraftSession minecraftSession;
    private final byte[] sharedSecret;
    private final byte[] verifyToken;

    public PacketEncryptionEvent(MinecraftSession minecraftSession, byte[] sharedSecret, byte[] verifyToken) {
        this.minecraftSession = minecraftSession;
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

    public byte[] getSharedSecret() {
        return sharedSecret;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }
}
