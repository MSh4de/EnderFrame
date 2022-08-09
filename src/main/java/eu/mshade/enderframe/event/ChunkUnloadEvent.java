package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.chunk.Chunk;

public class ChunkUnloadEvent extends EnderFrameEvent {

    private final Chunk chunk;

    public ChunkUnloadEvent(Chunk chunk) {
        this.chunk = chunk;
    }

    public Chunk getChunkBuffer() {
        return chunk;
    }

}
