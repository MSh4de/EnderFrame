package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.protocol.SessionWrapper;

public class PacketFinallyJoinEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;

    public PacketFinallyJoinEvent(SessionWrapper sessionWrapper) {
        this.sessionWrapper = sessionWrapper;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }
}
