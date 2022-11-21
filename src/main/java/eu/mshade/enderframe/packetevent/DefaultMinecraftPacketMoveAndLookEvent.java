package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class DefaultMinecraftPacketMoveAndLookEvent implements MinecraftPacketMoveAndLookEvent {

    private Player player;
    private double x, y, z;
    private float yaw, pitch;
    private boolean ground;

    public DefaultMinecraftPacketMoveAndLookEvent(Player player, double x, double y, double z, float yaw, float pitch, boolean ground) {
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isGround() {
        return ground;
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
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "PacketMoveAndLookEvent{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", yaw=" + yaw +
                ", pitch=" + pitch +
                ", ground=" + ground +
                '}';
    }
}
