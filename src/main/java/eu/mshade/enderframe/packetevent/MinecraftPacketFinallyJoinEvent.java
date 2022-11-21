package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketFinallyJoinEvent implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;

    public MinecraftPacketFinallyJoinEvent(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
