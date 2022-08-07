package eu.mshade.enderframe.world;


import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.MaterialKey;

import java.nio.charset.StandardCharsets;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public interface Chunk {

    int getX();

    int getZ();

    UUID getId();

    Queue<Player> getViewers();

    void addViewer(Player player);

    void removeViewer(Player player);

    World getWorld();

    Section[] getSections();

    AtomicLong getLastInteract();

    ChunkStatus getChunkStatus();

    void setChunkStatus(ChunkStatus chunkStatus);

    int getBitMask();

    int getBlock(int x, int y, int z);

    void setBlock(int x, int y, int z, MaterialKey block);

    byte getBlockLight(int x, int y, int z);

    void setBlockLight(int x, int y, int z, byte light);

    byte getSkyLight(int x, int y, int z);

    void setSkyLight(int x, int y, int z, byte light);

    void setBiome(int x, int z, int biome);

    int getBiome(int x, int z);

    byte[] getBiomes();

    AtomicInteger getAge();

    int getHighest(int x, int z);

    static UUID ofId(int x, int z){
        return UUID.nameUUIDFromBytes(String.format("%d,%d", x, z).getBytes(StandardCharsets.UTF_8));
    }

    Queue<Entity> getEntities();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void clearEntities();




}
