package eu.mshade.enderframe.entity;


import eu.mshade.mwork.MOptional;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class EntityIdManager {

    private static EntityIdManager entityIdManager;

    private final Queue<Integer> entitiesId = new ConcurrentLinkedQueue<>();
    private final AtomicInteger atomicId = new AtomicInteger();

    private EntityIdManager() {
        entityIdManager = this;
    }

    public static EntityIdManager get() {
        return (entityIdManager != null ? entityIdManager : new EntityIdManager());
    }

    public Integer getFreeId() {
        return MOptional.ofNullable(entitiesId.poll())
                .ifPresent(id -> id, atomicId.incrementAndGet());
    }

    public void flushId(int id) {
        entitiesId.add(id);
    }
}
