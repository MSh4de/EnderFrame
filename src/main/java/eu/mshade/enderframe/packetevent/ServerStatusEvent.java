
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Player;

public class ServerStatusEvent implements PacketEvent {

    private final EnderFrameSessionHandler enderFrameSessionHandler;

    public ServerStatusEvent(EnderFrameSessionHandler enderFrameSessionHandler) {
        this.enderFrameSessionHandler = enderFrameSessionHandler;
    }

    public EnderFrameSessionHandler getEnderFrameSessionHandler() {
        return enderFrameSessionHandler;
    }
}