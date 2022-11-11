package eu.mshade.enderframe.packetevent;


import eu.mshade.enderframe.protocol.MinecraftSession;

public class PacketLoginEvent implements PacketEvent {

    private MinecraftSession minecraftSession;
    private final String name;

    public PacketLoginEvent(MinecraftSession minecraftSession, String name) {
        this.minecraftSession = minecraftSession;
        this.name = name;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

    public String getName() {
        return name;
    }
}
