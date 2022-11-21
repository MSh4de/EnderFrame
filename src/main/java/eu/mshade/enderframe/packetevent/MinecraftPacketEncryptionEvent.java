package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketEncryptionEvent implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;
    private final byte[] sharedSecret;
    private final byte[] verifyToken;

    public MinecraftPacketEncryptionEvent(MinecraftSession minecraftSession, byte[] sharedSecret, byte[] verifyToken) {
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
