package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.SessionWrapper;

public class PacketKeepAliveEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;
    private final int threshold;

    public PacketKeepAliveEvent(SessionWrapper sessionWrapper, int threshold) {
        this.threshold = threshold;
        this.sessionWrapper = sessionWrapper;
    }

    public int getThreshold() {
        return threshold;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }
}
