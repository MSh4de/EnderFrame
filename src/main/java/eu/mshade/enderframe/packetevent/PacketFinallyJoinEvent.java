package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class PacketFinallyJoinEvent implements PacketEvent {

    private final Player player;

    public PacketFinallyJoinEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
