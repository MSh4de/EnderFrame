package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class PacketToggleFlyingEvent implements PacketEvent{

    private Player player;
    private boolean flying;

    public PacketToggleFlyingEvent(Player player, boolean flying) {
        this.player = player;
        this.flying = flying;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isFlying() {
        return flying;
    }
}
