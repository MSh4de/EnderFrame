package eu.mshade.enderframe.world.chunk;


import eu.mshade.enderframe.Watchable;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.world.ChunkStatus;
import eu.mshade.enderframe.world.World;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class Chunk implements Watchable {


    protected final int x;
    protected final int z;
    protected final long id;
    protected final World world;
    protected final Section[] sections = new Section[16];
    protected final Queue<Entity> entities = new ConcurrentLinkedQueue<>();
    protected final ChunkStateStore chunkStateStore = new ChunkStateStore();

    public Chunk(int x, int z, World world) {
        this.x = x;
        this.z = z;
        this.id = Chunk.key(x, z);
        this.world = world;
    }

    public int getX() {
        return this.x;
    }

    public int getZ() {
        return this.z;
    }

    public long getId() {
        return this.id;
    }

    public World getWorld() {
        return this.world;
    }

    public Section[] getSections() {
        return this.sections;
    }

    public ChunkStateStore getChunkStateStore() {
        return chunkStateStore;
    }

    public abstract int getBitMask();

    public abstract int getBlock(int x, int y, int z);

    public abstract void setBlock(int x, int y, int z, MaterialKey block);

    public abstract byte getBlockLight(int x, int y, int z);

    public abstract void setBlockLight(int x, int y, int z, byte light);

    public abstract byte getSkyLight(int x, int y, int z);

    public abstract void setSkyLight(int x, int y, int z, byte light);

    public abstract void setBiome(int x, int z, int biome);

    public abstract int getBiome(int x, int z);

    public abstract Section getSection(int y);

    public abstract byte[] getBiomes();

    public abstract int getHighest(int x, int z);

    public static long key(int x, int z) {
        return ((long) x & Integer.MAX_VALUE) << 32 | (long) z & Integer.MAX_VALUE;
    }

}
