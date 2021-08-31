package eu.mshade.enderframe.packetevent;

public class ServerPingEvent implements PacketEvent {

    private long payload;

    public ServerPingEvent(long payload) {
        this.payload = payload;
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
