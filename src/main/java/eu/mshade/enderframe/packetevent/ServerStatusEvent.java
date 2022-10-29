
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.SessionWrapper;

public class ServerStatusEvent implements PacketEvent {

    private SessionWrapper sessionWrapper;

    public ServerStatusEvent(SessionWrapper sessionWrapper) {
        this.sessionWrapper = sessionWrapper;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }

}