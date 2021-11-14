package eu.mshade.enderframe.packetevent;

public class DefaultPacketLookEvent implements PacketLookEvent{

    private float yaw, pitch;
    private boolean ground;


    public DefaultPacketLookEvent(float yaw, float pitch, boolean ground) {
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
    public String toString() {
        return "PacketLookEvent{" +
                "yaw=" + yaw +
                ", pitch=" + pitch +
                ", ground=" + ground +
                '}';
    }
}
