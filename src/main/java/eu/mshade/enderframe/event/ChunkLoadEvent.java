package eu.mshade.enderframe.event;

import eu.mshade.enderframe.world.chunk.Chunk;

import java.util.concurrent.CompletableFuture;

public class ChunkLoadEvent extends EnderFrameEvent {

    private final CompletableFuture<Chunk> chunk;

    public ChunkLoadEvent(CompletableFuture<Chunk> chunk) {
        this.chunk = chunk;
    }

    public CompletableFuture<Chunk> getChunk() {
        return chunk;
    }

}
