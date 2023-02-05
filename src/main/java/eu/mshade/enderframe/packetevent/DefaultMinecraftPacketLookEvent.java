package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class DefaultMinecraftPacketLookEvent implements MinecraftPacketLookEvent {

    protected Player player;
    private float yaw, pitch;
    private boolean ground;


    public DefaultMinecraftPacketLookEvent(Player player, float yaw, float pitch, boolean ground) {
        this.player = player;
        this.yaw = yaw;
        this.pitch = pitch;
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
    public float getYaw() {
        return yaw;
    }

    @Override
    public float getPitch() {
        return pitch;
    }

    @Override
    public String toString() {
        return "PacketLookEvent{" +
                "yaw=" + yaw +
                ", pitch=" + pitch +
                ", ground=" + ground +
                '}';
    }
}
