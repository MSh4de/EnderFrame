package eu.mshade.enderframe.packetevent;

public class DefaultPacketMoveEvent implements PacketMoveEvent{

    private double x, y, z;
    private boolean ground;

    public DefaultPacketMoveEvent(double x, double y, double z, boolean ground) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.ground = ground;
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
