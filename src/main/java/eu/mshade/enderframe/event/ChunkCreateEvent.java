package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.chunk.Chunk;

public class ChunkCreateEvent extends EnderFrameEvent {

    protected Chunk chunk;

    public ChunkCreateEvent(Chunk chunk) {
        this.chunk = chunk;
    }

    public Chunk getChunk() {
        return chunk;
    }
}
