package eu.mshadeproduction.enderframe.event.server;

import eu.mshadeproduction.enderframe.event.Event;

public class ServerPingEvent extends Event {

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
