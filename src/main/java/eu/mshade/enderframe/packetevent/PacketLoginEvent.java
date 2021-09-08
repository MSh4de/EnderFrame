package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Player;

public class PacketLoginEvent implements PacketEvent {

    private final EnderFrameSessionHandler enderFrameSessionHandler;
    private final String name;

    public PacketLoginEvent(EnderFrameSessionHandler enderFrameSessionHandler, String name) {
        this.enderFrameSessionHandler = enderFrameSessionHandler;
        this.name = name;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
    }

    public String getName() {
        return name;
    }
}
