package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class DefaultMinecraftPacketGroundEvent implements MinecraftPacketGroundEvent {

    private Player player;
    private boolean ground;

    public DefaultMinecraftPacketGroundEvent(Player player, boolean ground) {
        this.player = player;
        this.ground = ground;
    }

    @Override
    public boolean isGround() {
        return ground;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public String toString() {
        return "PacketGroundEvent{" +
                "ground=" + ground +
                '}';
    }
}
