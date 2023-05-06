
package eu.mshade.enderframe;

import eu.mshade.enderframe.event.MinecraftEvent;
import eu.mshade.enderframe.packetevent.MinecraftPacketEvent;
import eu.mshade.mwork.binarytag.BinaryTagDriver;
import eu.mshade.mwork.event.EventBus;

public class EnderFrame {

    private final EventBus<MinecraftPacketEvent> packetEvents = new EventBus<>();
    private final EventBus<MinecraftEvent> minecraftEvents = new EventBus<>();
    private final BinaryTagDriver binaryTagDriver = new BinaryTagDriver();
    private static EnderFrame ENDER_FRAME;

    private EnderFrame() {
        ENDER_FRAME = this;
    }

    public EventBus<MinecraftPacketEvent> getPacketEvents() {
        return packetEvents;
    }

    public EventBus<MinecraftEvent> getMinecraftEvents() {
        return minecraftEvents;
    }

    public BinaryTagDriver getBinaryTagDriver() {
        return binaryTagDriver;
    }

    public static EnderFrame get(){
        return (ENDER_FRAME != null ? ENDER_FRAME : new EnderFrame());
    }
}