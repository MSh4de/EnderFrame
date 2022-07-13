package eu.mshade.enderframe.packetevent;

public class PacketToggleFlyingEvent implements PacketEvent{

    private boolean flying;

    public PacketToggleFlyingEvent(boolean flying) {
        this.flying = flying;
    }

    public boolean isFlying() {
        return flying;
    }
}
