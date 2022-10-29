package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.SessionWrapper;

public class ServerPingEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;
    private final long payload;

    public ServerPingEvent(SessionWrapper sessionWrapper, long payload) {
        this.payload = payload;
        this.sessionWrapper = sessionWrapper;
    }
    public long getPayload() {
        return payload;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }

    @Override
    public String toString() {
        return "ServerPingEvent{" +
                "payload=" + payload +
                '}';
    }
}
