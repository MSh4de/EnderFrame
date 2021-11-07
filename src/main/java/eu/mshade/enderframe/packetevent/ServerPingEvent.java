package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Player;

public class ServerPingEvent implements PacketEvent {

    private final EnderFrameSessionHandler enderFrameSessionHandler;
    private final long payload;

    public ServerPingEvent(EnderFrameSessionHandler enderFrameSessionHandler, long payload) {
        this.enderFrameSessionHandler = enderFrameSessionHandler;
        this.payload = payload;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
    }

    public long getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "ServerPingEvent{" +
                "payload=" + payload +
                '}';
    }
}
