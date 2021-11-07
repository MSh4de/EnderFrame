package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class PacketKeepAliveEvent implements PacketEvent {

    private final Player player;
    private final int threshold;

    public PacketKeepAliveEvent(Player player, int threshold) {
        this.player = player;
        this.threshold = threshold;
    }

    public Player getPlayer() {
        return player;
    }

    public int getThreshold() {
        return threshold;
    }
}
