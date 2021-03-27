package eu.mshadeproduction.enderframe.entity;

import eu.mshadeproduction.enderframe.world.Chunk;

import java.util.List;

public interface Player extends Entity {

    String getName();

    void loadChunks(List<Chunk> chunks);

    void loadChunk(Chunk chunk);

    void unLoadChunks(List<Chunk> chunks);

    void unLoadChunk(Chunk chunk);

}
