package eu.mshade.enderframe.world.chunk;


import eu.mshade.enderframe.Agent;
import eu.mshade.enderframe.Watchable;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.world.World;
import eu.mshade.enderframe.world.block.Block;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Chunk implements Watchable {


    public static final int WIDTH = 16, HEIGHT = 16, DEPTH = 256, SEC_DEPTH = 16;

    protected final int x;
    protected final int z;
    protected final long id;
    protected final World world;
    protected final Section[] sections = new Section[16];
    protected final Queue<Entity> entities = new ConcurrentLinkedQueue<>();
    protected final ChunkStateStore chunkStateStore = new ChunkStateStore();
    protected final Agent agent = Agent.from("Chunk");

    public Chunk(int x, int z, World world) {
        this.x = x;
        this.z = z;
        this.id = key(x, z);
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

    public boolean isSectionsEmpty() {
        for (Section section : sections) {
            if (section != null) return false;
        }
        return true;
    }

    public ChunkStateStore getChunkStateStore() {
        return chunkStateStore;
    }

    public Agent getAgent() {
        return agent;
    }

    public Collection<Block> getBlocks() {
        Collection<Block> blocks = new ArrayList<>();
        for (Section section : sections) {
            if (section == null) continue;
            blocks.addAll(section.getPalette().getBlock());
        }
        return blocks;
    }

    public int getBitMask(){
        int sectionBitmask = 0;
        for (int i = 0; i < sections.length; i++) {
            Section section = sections[i];
            if (section != null && section.getRealBlock() != 0) {
                sectionBitmask |= 1 << i;
            }
        }
        return sectionBitmask;
    }

    public abstract Block getBlock(int x, int y, int z);

    public abstract void setBlock(int x, int y, int z, Block block);

    public abstract byte getBlockLight(int x, int y, int z);

    public abstract void setBlockLight(int x, int y, int z, byte light);

    public abstract byte getSkyLight(int x, int y, int z);

    public abstract void setSkyLight(int x, int y, int z, byte light);

    public abstract void setBiome(int x, int z, int biome);

    public abstract int getBiome(int x, int z);

    public abstract Section getSectionOrCreate(int y);

    public Section getSection(int y){
        return sections[y];
    }

    public boolean hasSection(int y){
        return getSection(y) != null;
    }

    public abstract Section createSection(int y);

    public abstract byte[] getBiomes();

    public abstract void setBiomes(byte[] biomes);

    public int getHighest(int x, int z){
        for (int i = 255; i > 0; i--) {
            if (getBlock(x, i, z).getMaterialKey() != Material.AIR) {
                return i;
            }
        }
        return 0;
    }

    public Queue<Entity> getEntities() {
        return entities;
    }

    public static long key(int x, int z) {
        return ((long) x & 0xffffffffL) << 32 | (long) z & 0xffffffffL;
    }

    public int getBiomeIndex(int x, int z) {
        return (z & 0xF) * WIDTH + (x & 0xF);
    }

    public int getBlockIndex(int x, int y, int z) {
        return ((y & 0xf) << 8) | ((z & 0x0f) << 4) | (x & 0x0f);
    }

}
