package eu.mshade.enderframe;


import java.util.Collection;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class UniqueId implements Cloneable {

    private final Queue<Integer> freeId = new ConcurrentLinkedQueue<>();
    private final AtomicInteger atomicId;

    public UniqueId() {
        this.atomicId = new AtomicInteger(0);
    }

    public UniqueId(int offset) {
        this.atomicId = new AtomicInteger(offset);
    }

    public UniqueId(int offset, Collection<Integer> freeId) {
        this.atomicId = new AtomicInteger(offset);
        this.freeId.addAll(freeId);
    }

    public Integer getFreeId() {
        return Optional.ofNullable(freeId.poll()).orElseGet(atomicId::getAndIncrement);
    }

    public void flushId(int id) {
        freeId.add(id);
    }

    public AtomicInteger getAtomicId() {
        return atomicId;
    }

    public Queue<Integer> getFreeIdQueue() {
        return freeId;
    }

    @Override
    public UniqueId clone() {
        try {
            return (UniqueId) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
