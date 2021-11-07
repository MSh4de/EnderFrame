package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Player;

public class PacketEncryptionEvent implements PacketEvent {

    private final EnderFrameSessionHandler enderFrameSessionHandler;
    private final byte[] sharedSecret;
    private final byte[] verifyToken;

    public PacketEncryptionEvent(EnderFrameSessionHandler enderFrameSessionHandler, byte[] sharedSecret, byte[] verifyToken) {
        this.enderFrameSessionHandler = enderFrameSessionHandler;
        this.sharedSecret = sharedSecret;
        this.verifyToken = verifyToken;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
    }

    public byte[] getSharedSecret() {
        return sharedSecret;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }
}
