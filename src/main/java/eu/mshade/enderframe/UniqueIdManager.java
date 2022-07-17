package eu.mshade.enderframe;

import eu.mshade.mwork.MOptional;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdManager {

    private final Queue<Integer> freeId = new ConcurrentLinkedQueue<>();
    private final AtomicInteger atomicId = new AtomicInteger(1);

    public Integer getFreeId() {
        return Optional.ofNullable(freeId.poll()).orElseGet(atomicId::getAndIncrement);
    }

    public void flushId(int id) {
        freeId.add(id);
    }

}
