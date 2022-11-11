package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.MinecraftSession;

public class PacketFinallyJoinEvent implements PacketEvent {

    private MinecraftSession minecraftSession;

    public PacketFinallyJoinEvent(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
