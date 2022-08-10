package eu.mshade.enderframe.world.chunk;

import eu.mshade.enderframe.world.ChunkStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ChunkStateStore {

    protected ChunkStatus chunkStatus;
    protected ChunkStatus lastChunkStatus;
    protected Map<ChunkStatus, Long> trackedTime = new ConcurrentHashMap<>();
    protected AtomicBoolean inChunkSafeguard = new AtomicBoolean(false);
    protected AtomicLong lastInteract = new AtomicLong(System.currentTimeMillis());
    protected AtomicInteger age = new AtomicInteger(0);
    protected Runnable finishWrite;
    protected AtomicBoolean autoSave = new AtomicBoolean(true);

    public ChunkStateStore() {
        this.chunkStatus = ChunkStatus.PREPARE_TO_LOAD;
        this.lastChunkStatus = chunkStatus;
        this.trackedTime.put(chunkStatus, System.currentTimeMillis());
    }

    public ChunkStatus getChunkStatus() {
        return chunkStatus;
    }

    public void setChunkStatus(ChunkStatus chunkStatus) {
        this.lastChunkStatus = this.chunkStatus;
        this.chunkStatus = chunkStatus;
        this.trackedTime.put(chunkStatus, System.currentTimeMillis());
    }

    public void joinChunkSafeguard() {
        this.inChunkSafeguard.set(true);
    }

    public void leaveChunkSafeguard() {
        this.inChunkSafeguard.set(false);
    }

    public boolean isInChunkSafeguard() {
        return this.inChunkSafeguard.get();
    }

    public void interact() {
        this.lastInteract.set(System.currentTimeMillis());
    }

    public boolean outdatedInteract(long timeout) {
        return System.currentTimeMillis() - this.lastInteract.get() > timeout;
    }

    public boolean outdatedChunkStatus(long timeout) {
        return System.currentTimeMillis() - this.trackedTime.get(this.chunkStatus) > timeout;
    }

    public boolean outdatedChunkStatus(ChunkStatus chunkStatus, long timeout) {
        return System.currentTimeMillis() - this.trackedTime.getOrDefault(chunkStatus, 0L) > timeout;
    }

    public int getAge() {
        return age.get();
    }

    public int addAndGetAge(int add) {
        return age.addAndGet(add);
    }

    public void resetAge() {
        this.age.set(0);
    }

    public void setFinishWrite(Runnable finishWrite) {
        this.finishWrite = finishWrite;
    }

    public void finishWrite() {
        if(this.finishWrite != null) {
            this.finishWrite.run();
        }
    }

    public void enableAutoSave() {
        this.autoSave.set(true);
    }

    public void disableAutoSave() {
        this.autoSave.set(false);
    }

    public boolean isAutoSaveEnabled() {
        return this.autoSave.get();
    }




}
