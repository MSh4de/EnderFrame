
package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class ServerStatusEvent implements PacketEvent {

    private final Player player;
    public ServerStatusEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}