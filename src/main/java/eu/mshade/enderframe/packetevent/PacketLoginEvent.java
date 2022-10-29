package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.SessionWrapper;

public class PacketLoginEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;
    private final String name;

    public PacketLoginEvent(SessionWrapper sessionWrapper, String name) {
        this.sessionWrapper = sessionWrapper;
        this.name = name;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }

    public String getName() {
        return name;
    }
}
