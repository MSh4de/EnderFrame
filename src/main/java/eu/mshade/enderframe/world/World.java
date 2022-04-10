package eu.mshade.enderframe.world;

import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.entity.Player;

import java.io.File;
import java.util.Collection;
import java.util.Queue;
import java.util.UUID;

public interface World {

    WorldLevel getWorldLevel();

    Collection<Chunk> getChunkBuffers();

    void flushChunkBuffer(Chunk chunk);

    Chunk getChunkBuffer(int chunkX, int chunkZ);

    Chunk getChunkBuffer(UUID id);

    void addChunkBuffer(Chunk chunk);

    File getChunkFile(int chunkX, int chunkZ);

    boolean hasChunkBuffer(int x, int z);

    ChunkGenerator getChunkGenerator();

    void setChunkGenerator(ChunkGenerator chunkGenerator);

    File getChunksFolder();

    File getWorldFolder();

    Queue<Entity> getEntities();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    Entity spawnEntity(EntityType entityType, Location location);

    Player spawnPlayer(EnderFrameSessionHandler sessionHandler, Location location);
}
