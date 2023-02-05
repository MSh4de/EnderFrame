package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class MinecraftPacketToggleFlyingEvent implements MinecraftPacketEvent {

    private Player player;
    private boolean flying;

    public MinecraftPacketToggleFlyingEvent(Player player, boolean flying) {
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
