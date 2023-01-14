package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.chunk.Chunk;

public class WatchdogUnseeEvent extends EnderFrameEvent {

    private final Chunk chunk;

    public WatchdogUnseeEvent(Chunk chunk) {
        this.chunk = chunk;
    }

    public Chunk getChunkBuffer() {
        return chunk;
    }
}
