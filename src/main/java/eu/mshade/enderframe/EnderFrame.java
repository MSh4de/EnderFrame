
package eu.mshade.enderframe;

import eu.mshade.enderframe.event.PacketEvent;
import eu.mshade.mwork.event.EventBus;

public class EnderFrame {

    private final EventBus<PacketEvent> packetEventBus = new EventBus<>();
    private static EnderFrame ENDER_FRAME;

    private EnderFrame() {
        ENDER_FRAME = this;
    }

    public EventBus<PacketEvent> getPacketEventBus() {
        return packetEventBus;
    }

    public static EnderFrame get(){
        return (ENDER_FRAME != null ? ENDER_FRAME : new EnderFrame());
    }
}