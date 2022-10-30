package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.Chunk;

public class WatchdogSeeEvent extends EnderFrameEvent {

    private final Chunk chunk;

    public WatchdogSeeEvent(Chunk chunk) {
        this.chunk = chunk;
    }

    public Chunk getChunkBuffer() {
        return chunk;
    }
}
