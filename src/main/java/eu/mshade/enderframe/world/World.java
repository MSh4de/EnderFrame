package eu.mshade.enderframe.world;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.EntityType;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.metadata.world.WorldMetadataType;
import eu.mshade.enderframe.tick.Tickable;
import eu.mshade.mwork.binarytag.poet.BinaryTagPoet;

import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class World extends Tickable {

    protected final File worldFolder;
    protected final File regionFolder;
    protected final File indicesFolder;

    protected final MetadataKeyValueBucket metadataKeyValueBucket;
    protected final Map<UUID, Chunk> chunks = new ConcurrentHashMap<>();
    protected final Queue<Entity> entities = new ConcurrentLinkedQueue<>();
    protected ChunkGenerator chunkGenerator;


    public World(File worldFolder, MetadataKeyValueBucket metadataKeyValueBucket) {
        this.worldFolder = worldFolder;
        this.regionFolder = new File(worldFolder, "regions");
        this.indicesFolder = new File(worldFolder, "indices");
        this.metadataKeyValueBucket = metadataKeyValueBucket;
    }

    public World(File worldFolder) {
        this(worldFolder, new MetadataKeyValueBucket());
    }

    public void flushChunk(Chunk chunk){
        flushChunk(chunk, true);
   }

   public abstract void flushChunk(Chunk chunk, boolean save);

   public abstract Chunk getChunk(int chunkX, int chunkZ);

   public abstract Chunk getChunk(UUID id);

   public abstract void addChunkBuffer(Chunk chunk);

   public abstract boolean hasChunkBuffer(int x, int z);

   public abstract void addEntity(Entity entity);

   public abstract void removeEntity(Entity entity);

   public abstract Entity spawnEntity(EntityType entityType, Location location);

   public abstract Collection<BinaryTagPoet> getRegionBinaryTagPoets();

   public abstract void setBlock(int x, int y, int z, MaterialKey materialKey);

   public String getName(){
       return this.metadataKeyValueBucket.getValueOfMetadataKeyValue(WorldMetadataType.NAME, String.class);
   }

    public ChunkGenerator getChunkGenerator(){
        return chunkGenerator;
    }

    public void setChunkGenerator(ChunkGenerator chunkGenerator){
        this.chunkGenerator = chunkGenerator;
    }

    public File getRegionFolder(){
        return this.regionFolder;
    }

    public File getIndicesFolder() {
        return indicesFolder;
    }

    public File getWorldFolder(){
        return this.worldFolder;
    }

    public Queue<Entity> getEntities(){
        return this.entities;
    }

    public Collection<Chunk> getChunks(){
        return this.chunks.values();
    }

    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
    }


}
