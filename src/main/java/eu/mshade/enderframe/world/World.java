package eu.mshade.enderframe.world;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.tick.Tickable;
import eu.mshade.enderframe.world.block.Block;
import eu.mshade.enderframe.world.chunk.Chunk;
import eu.mshade.enderframe.world.chunk.ChunkGenerator;
import eu.mshade.mwork.binarytag.segment.SegmentBinaryTag;

import java.io.File;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class World extends Tickable {


    protected final File worldFolder;
    protected final File regionFolder;
    protected final File indicesFolder;

    protected final MetadataKeyValueBucket metadataKeyValueBucket;
    protected final Map<Long, CompletableFuture<Chunk>> chunkById = new ConcurrentHashMap<>();
    protected final Queue<Entity> entities = new ConcurrentLinkedQueue<>();
    protected ChunkGenerator chunkGenerator;


    public World(File worldFolder, MetadataKeyValueBucket metadataKeyValueBucket) {
        this.worldFolder = worldFolder;
        this.regionFolder = new File(worldFolder, "regions");
        this.indicesFolder = new File(worldFolder, "indices");
        this.metadataKeyValueBucket = metadataKeyValueBucket;
    }

    public World(File worldFolder) {
        this(worldFolder, new MetadataKeyValueBucket(true));
    }

    /**
     * Flushes the chunk from memory to disk with saving the chunk data
     * Checks method {@link #flushChunk(Chunk, boolean)} for disabling the saving
     * @param chunk the chunk to flush
     */
    public void flushChunk(Chunk chunk) {
        flushChunk(chunk, true);
    }

    /**
     * Saves the chunk data to disk
     * @param chunk the chunk to save
     */
    public abstract void saveChunk(Chunk chunk);

    /**
     * Flushes the chunk from the memory and saves it to the disk
     * @param chunk the chunk to flush
     * @param save whether to save the chunk or not
     */
    public abstract void flushChunk(Chunk chunk, boolean save);

    /**
     * Gets the chunk at the given coordinates.
     * If the chunk is not loaded, it will be loaded.
     * If the chunk is not generated, it will be generated.
     * @param chunkX The chunk x coordinate
     * @param chunkZ The chunk z coordinate
     * @return {@link CompletableFuture} of the chunk
     */
    public abstract CompletableFuture<Chunk> getChunk(int chunkX, int chunkZ);

    /**
     * Gets chunk by id (chunkX + chunkZ * 2^32)
     * @param id chunk id
     * @return chunk future or null if chunk is not loaded
     */
    public abstract CompletableFuture<Chunk> getChunk(long id);

    /**
     * Checks if the chunk is loaded in the world
     * @param chunkX the chunk x
     * @param chunkZ the chunk z
     * @return true if the chunk is loaded
     */
    public abstract boolean hasChunkLoaded(int chunkX, int chunkZ);

    /**
     * Checks if the {@link Chunk} exists in the {@link World} so we're going to read it from the disk
     * @param chunkX the chunk x
     * @param chunkZ the chunk z
     * @return true if the {@link Chunk} exists
     */
    public abstract boolean isChunkExists(int chunkX, int chunkZ);

    public abstract void addEntity(Entity entity);

    public abstract void removeEntity(Entity entity);

    public abstract Entity spawnEntity(EntityType entityType, Location location);
    /**
     * Gets all the regions in the world
     * @return the regions
     */
    public abstract Collection<SegmentBinaryTag> getRegions();

    public abstract void setBlock(int x, int y, int z, MaterialKey materialKey);

    public void setBlock(Vector vector, MaterialKey materialKey) {
        setBlock(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ(), materialKey);
    }

    public abstract void setBlock(int x, int y, int z, Block block);

    public void setBlock(Vector vector, Block block) {
        setBlock(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ(), block);
    }

    public abstract Block getBlock(int x, int y, int z);

    public Block getBlock(Vector vector) {
        return getBlock(vector.getBlockX(), vector.getBlockY(), vector.getBlockZ());
    }

    public abstract void saveWorld();

    public String getName() {
        return this.metadataKeyValueBucket.getValueOfMetadataKeyValue(WorldMetadataType.NAME, String.class);
    }

    public Dimension getDimension() {
        return this.metadataKeyValueBucket.getValueOfMetadataKeyValue(WorldMetadataType.DIMENSION, Dimension.class);
    }

    public ChunkGenerator getChunkGenerator() {
        return chunkGenerator;
    }

    public void setChunkGenerator(ChunkGenerator chunkGenerator) {
        this.chunkGenerator = chunkGenerator;
    }

    public File getRegionFolder() {
        return this.regionFolder;
    }

    public File getIndicesFolder() {
        return indicesFolder;
    }

    public File getWorldFolder() {
        return this.worldFolder;
    }

    public Queue<Entity> getEntities() {
        return this.entities;
    }

    public Collection<CompletableFuture<Chunk>> getChunks() {
        return this.chunkById.values();
    }

    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
    }


}
