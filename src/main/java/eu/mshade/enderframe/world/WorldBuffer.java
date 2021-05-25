package eu.mshade.enderframe.world;

import java.io.File;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public interface WorldBuffer {

    WorldLevel getWorldLevel();

    Collection<ChunkBuffer> getChunkBuffers();

    void flushChunkBuffer(ChunkBuffer chunkBuffer);

    CompletableFuture<ChunkBuffer> getChunkBuffer(int x, int z);

    boolean hasFileChunkBuffer(int x, int z);

    boolean hasChunkBuffer(int x, int z);

    ChunkGenerator getChunkGenerator();

    void setChunkGenerator(ChunkGenerator chunkGenerator);

    File getChunksFolder();

    File getWorldFolder();
}
