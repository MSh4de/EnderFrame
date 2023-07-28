package eu.mshade.enderframe.world

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.EntityKey
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.tick.Tickable
import eu.mshade.enderframe.world.block.Block
import eu.mshade.enderframe.world.chunk.Chunk
import eu.mshade.enderframe.world.chunk.ChunkGenerator
import eu.mshade.mwork.binarytag.segment.SegmentBinaryTag
import java.io.File
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

abstract class World(
    val worldFolder: File,
    metadatas: MetadataKeyValueBucket = MetadataKeyValueBucket(true)
) : Tickable() {


    val regionFolder: File
    val levelFile: File

    @JvmField
    val metadatas: MetadataKeyValueBucket
    protected val chunkById = ConcurrentHashMap<Long, CompletableFuture<Chunk>>()
    val entities: Queue<Entity> = ConcurrentLinkedQueue()
    var chunkGenerator: ChunkGenerator? = null
    protected val entityByUuid: MutableMap<UUID, Entity> = ConcurrentHashMap()

    init {
        regionFolder = File(worldFolder, "regions")
        levelFile = File(worldFolder, "level.dat")
        this.metadatas = metadatas
        regionFolder.mkdirs()
    }

    @Deprecated("")
    fun putEntity(entity: Entity) {
        entityByUuid[entity.uniqueId] = entity
    }

    /**
     * Flushes the chunk from memory to disk with saving the chunk data
     * Checks method [.flushChunk] for disabling the saving
     * @param chunk the chunk to flush
     */
    fun flushChunk(chunk: Chunk) {
        flushChunk(chunk, true)
    }

    /**
     * Saves the chunk data to disk
     * @param chunk the chunk to save
     */
    abstract fun saveChunk(chunk: Chunk)

    /**
     * Flushes the chunk from the memory and saves it to the disk
     * @param chunk the chunk to flush
     * @param save whether to save the chunk or not
     */
    abstract fun flushChunk(chunk: Chunk, save: Boolean)

    /**
     * Gets the chunk at the given coordinates.
     * If the chunk is not loaded, it will be loaded.
     * If the chunk is not generated, it will be generated.
     * @param chunkX The chunk x coordinate
     * @param chunkZ The chunk z coordinate
     * @return [CompletableFuture] of the chunk
     */
    abstract fun getChunk(chunkX: Int, chunkZ: Int): CompletableFuture<Chunk>?

    /**
     * Gets chunk by id (chunkX + chunkZ * 2^32)
     * @param id chunk id
     * @return chunk future or null if chunk is not loaded
     */
    abstract fun getChunk(id: Long): CompletableFuture<Chunk>?

    /**
     * Checks if the chunk is loaded in the world
     * @param chunkX the chunk x
     * @param chunkZ the chunk z
     * @return true if the chunk is loaded
     */
    abstract fun hasChunkLoaded(chunkX: Int, chunkZ: Int): Boolean

    /**
     * Checks if the [Chunk] exists in the [World] so we're going to read it from the disk
     * @param chunkX the chunk x
     * @param chunkZ the chunk z
     * @return true if the [Chunk] exists
     */
    abstract fun isChunkExists(chunkX: Int, chunkZ: Int): Boolean
    abstract fun addEntity(entity: Entity)
    abstract fun removeEntity(entity: Entity)
    abstract fun spawnEntity(entityType: EntityKey, location: Location): Entity

    /**
     * Gets all the regions in the world
     * @return the regions
     */
    abstract val regions: Collection<SegmentBinaryTag>


    abstract fun setBlock(x: Int, y: Int, z: Int, materialKey: MaterialKey)
    fun setBlock(vector: Vector, materialKey: MaterialKey) {
        setBlock(vector.blockX, vector.blockY, vector.blockZ, materialKey)
    }

    abstract fun setBlock(x: Int, y: Int, z: Int, block: Block)

    fun setBlock(vector: Vector, block: Block) {
        setBlock(vector.blockX, vector.blockY, vector.blockZ, block)
    }

    abstract fun getBlock(x: Int, y: Int, z: Int): Block
    fun getBlock(vector: Vector): Block {
        return getBlock(vector.blockX, vector.blockY, vector.blockZ)
    }

    abstract fun saveLevel()
    val name: String
        get() = metadatas.getMetadataKeyValue(WorldMetadataType.NAME).metadataValue as String
    open val dimension: Dimension?
        get() = metadatas.getMetadataKeyValue(WorldMetadataType.DIMENSION).metadataValue as Dimension
    open val difficulty: Difficulty
        get() = metadatas.getMetadataKeyValue(WorldMetadataType.DIFFICULTY).metadataValue as Difficulty
    val seed: Long
        get() {
            val metadataKeyValue = metadatas.getMetadataKeyValue(WorldMetadataType.SEED) ?: return 0
            return metadataKeyValue.metadataValue as Long
        }
    val chunks: Collection<CompletableFuture<Chunk>>
        get() = chunkById.values

    fun getEntityByUuid(uuid: UUID): Entity? {
        return entityByUuid[uuid]
    }
}
