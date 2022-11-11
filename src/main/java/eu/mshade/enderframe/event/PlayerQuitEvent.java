package eu.mshade.enderframe.event;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class PlayerQuitEvent extends EnderFrameEvent{

    private MinecraftSession minecraftSession;

    public PlayerQuitEvent(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
