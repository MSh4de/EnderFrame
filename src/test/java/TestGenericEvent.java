import eu.mshade.enderframe.packetevent.*;
import eu.mshade.mwork.event.EventBus;
import eu.mshade.mwork.event.EventFilter;
import eu.mshade.mwork.event.EventPriority;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TestGenericEvent {

    public static void main(String[] args) throws Exception {
/*
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        EventBus<PacketEvent> eventBus = new EventBus<>();
        eventBus.subscribe(PacketMoveEvent.class, (event, eventContainer) -> {
            System.out.println("HELLO");
        }).withEventPriority(EventPriority.LOW).withEventFilter(EventFilter.DERIVE);
        eventBus.subscribe(PacketMoveEvent.class, (event, eventContainer) -> {
            System.out.println(event);
        }).withEventFilter(EventFilter.DERIVE);

        eventBus.publish(new DefaultPacketGroundEvent(false));
        eventBus.publish(new DefaultPacketLookEvent(0, 0, false));
        eventBus.publish(new DefaultPacketMoveEvent(0, 0, 0, false));
        eventBus.publish(new DefaultPacketMoveAndLookEvent(0, 0, 0, 0, 0,false));
*/



    }

}
