package eu.mshade.enderframe.packetevent;

public class DefaultPacketGroundEvent implements PacketGroundEvent{

    private boolean ground;

    public DefaultPacketGroundEvent(boolean ground) {
        this.ground = ground;
    }

    @Override
    public boolean isGround() {
        return ground;
    }

    @Override
    public String toString() {
        return "PacketGroundEvent{" +
                "ground=" + ground +
                '}';
    }
}
