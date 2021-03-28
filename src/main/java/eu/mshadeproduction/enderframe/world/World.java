package eu.mshadeproduction.enderframe.world;

import java.util.Queue;

public interface World {

    String getName();

    long getSeed();

    void setBlock(int x, int y, int z, Block block);

    Block getBlock(int x, int y, int z);

    Chunk getChunk(int x, int z);

    Queue<Chunk> getChunks();

    void setChunkGenerator(ChunkGenerator chunkGenerator);

    ChunkGenerator getChunkGenerator();

}
