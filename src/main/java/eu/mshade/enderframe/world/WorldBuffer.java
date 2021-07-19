package eu.mshade.enderframe.world;

import java.io.File;
import java.util.Collection;
import java.util.UUID;

public interface WorldBuffer {

    WorldLevel getWorldLevel();

    Collection<ChunkBuffer> getChunkBuffers();

    void flushChunkBuffer(ChunkBuffer chunkBuffer);

    ChunkBuffer getChunkBuffer(int chunkX, int chunkZ);

    ChunkBuffer getChunkBuffer(UUID id);

    void addChunkBuffer(ChunkBuffer chunkBuffer);

    boolean hasFileChunkBuffer(int x, int z);

    File getChunkFile(int chunkX, int chunkZ);

    File getChunkFile(UUID id);

    boolean hasChunkBuffer(int x, int z);

    ChunkGenerator getChunkGenerator();

    void setChunkGenerator(ChunkGenerator chunkGenerator);

    File getChunksFolder();

    File getWorldFolder();
}
