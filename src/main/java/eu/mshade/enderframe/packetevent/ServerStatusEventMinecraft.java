
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class ServerStatusEventMinecraft implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;

    public ServerStatusEventMinecraft(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

}