package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.Chunk;

public class ChunkLoadEvent extends EnderFrameEvent {

    private final Chunk chunk;

    public ChunkLoadEvent(Chunk chunk) {
        this.chunk = chunk;
    }

    public Chunk getChunkBuffer() {
        return chunk;
    }

}
