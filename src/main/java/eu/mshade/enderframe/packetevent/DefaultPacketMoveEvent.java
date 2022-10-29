package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class DefaultPacketMoveEvent implements PacketMoveEvent{

    private Player player;
    private double x, y, z;
    private boolean ground;

    public DefaultPacketMoveEvent(Player player, double x, double y, double z, boolean ground) {
        this.player = player;
        this.x = x;
        this.y = y;
        this.z = z;
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
        return "PacketMoveEvent{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", ground=" + ground +
                '}';
    }
}
