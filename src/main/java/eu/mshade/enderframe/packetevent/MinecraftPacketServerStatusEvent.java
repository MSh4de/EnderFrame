
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketServerStatusEvent implements MinecraftPacketEvent {

    private MinecraftSession minecraftSession;

    public MinecraftPacketServerStatusEvent(MinecraftSession minecraftSession) {
        this.minecraftSession = minecraftSession;
    }

    public MinecraftSession getMinecraftSession() {
        return minecraftSession;
    }

}