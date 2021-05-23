
package eu.mshadeproduction.enderframe;

import eu.mshadeproduction.enderframe.event.Event;
import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.mwork.dispatcher.DefaultDispatcherDriver;
import eu.mshadeproduction.mwork.dispatcher.DispatcherDriver;

public class EnderFrame {

    private final DispatcherDriver<Event> eventDispatcherDriver = new DefaultDispatcherDriver<>();
    private static EnderFrame ENDER_FRAME;

    private EnderFrame() {
        ENDER_FRAME = this;
    }

    public DispatcherDriver<Event> getEventDispatcherDriver() {
        return eventDispatcherDriver;
    }

    public static EnderFrame get(){
        return (ENDER_FRAME != null ? ENDER_FRAME : new EnderFrame());
    }
}