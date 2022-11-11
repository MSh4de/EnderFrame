
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class ServerStatusEvent implements PacketEvent {

    private MinecraftSession minecraftSession;

    public ServerStatusEvent(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

}