package eu.mshade.enderframe.world;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.entity.Player;

import java.io.File;
import java.util.Collection;
import java.util.Queue;
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

    Queue<Entity> getEntities();

    void addEntity(Entity entity);

    Entity spawnEntity(EntityType entityType, Location location);

    Player spawnPlayer(EnderFrameSessionHandler sessionHandler, Location location);
}
