package eu.mshade.enderframe.world;


import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.MaterialKey;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Chunk {


    private final int x;
    private final int z;
    private final long id;
    private final World world;

    public Chunk(int x, int z, World world) {
        this.x = x;
        this.z = z;
        this.id = Chunk.key(x, z);
        this.world = world;
    }

    public int getX(){
        return this.x;
    }

    public int getZ(){
        return this.z;
    }

    public long getId(){
        return this.id;
    }

    AtomicBoolean getInChunkSafeguard();

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

    Queue<Entity> getEntities();

    void addEntity(Entity entity);

    void removeEntity(Entity entity);

    void clearEntities();

    Section getSection(int y);

    // create unique key from two ints and return positive long
    public static long key(int x, int z){
        return ((long) x & 0xFFFF) << 32 | ((long) z & 0xFFFF);
    }
}
