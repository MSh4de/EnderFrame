package eu.mshade.enderframe.packetevent;

public class DefaultPacketMoveAndLookEvent implements PacketMoveAndLookEvent{

    private double x, y, z;
    private float yaw, pitch;
    private boolean ground;

    public DefaultPacketMoveAndLookEvent(double x, double y, double z, float yaw, float pitch, boolean ground) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.ground = ground;
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
