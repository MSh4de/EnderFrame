package eu.mshade.enderframe.event;

import eu.mshade.enderframe.protocol.SessionWrapper;

public class PlayerQuitEvent extends EnderFrameEvent{

    private SessionWrapper sessionWrapper;

    public PlayerQuitEvent(SessionWrapper sessionWrapper) {
        this.sessionWrapper = sessionWrapper;
    }

    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }
}
