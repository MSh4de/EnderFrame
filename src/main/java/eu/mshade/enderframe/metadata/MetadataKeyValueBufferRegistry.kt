package eu.mshade.enderframe.metadata

import eu.mshade.mwork.binarytag.BinaryTag
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag
import org.slf4j.LoggerFactory

class MetadataKeyValueBufferRegistry {
    private val metadataKeyByName: MutableMap<String, MetadataKey> = HashMap()
    private val metadataKeyValueBuffer: MutableMap<MetadataKey, MetadataKeyValueBuffer> = HashMap()

    init {
/*        register(WorldMetadataType.NAME, NameWorldMetadataBuffer())
        register(WorldMetadataType.SEED, SeedWorldMetadataBuffer())
        register(WorldMetadataType.DIMENSION, DimensionWorldMetadataBuffer(binaryTagDriver))
        register(WorldMetadataType.LEVEL_TYPE, LevelTypeWorldMetadataBuffer(binaryTagDriver))
        register(WorldMetadataType.DIFFICULTY, DifficultyWorldMetadataBuffer(binaryTagDriver))
        register(WorldMetadataType.PARENT, ParentWorldMetadataBuffer())

        register(BlockMetadataType.EXTRA, ExtraBlockMetadataBuffer())
        register(BlockMetadataType.FACE, FaceBlockMetadataBuffer())
        register(BlockMetadataType.HALF, HalfBlockMetadataBuffer())
        register(BlockMetadataType.SHAPE, ShapeBlockMetadataBuffer())
        register(BlockMetadataType.AXIS, AxisBlockMetadataBuffer())
        register(BlockMetadataType.POWERED, PoweredBlockMetadataBuffer())
        register(BlockMetadataType.POWER, PowerBlockMetadataBuffer())
        register(BlockMetadataType.DECAYABLE, DecayableBlockMetadataBuffer())
        register(BlockMetadataType.CHECK_DECAY, CheckDecayBlockMetadataBuffer())
        register(BlockMetadataType.SEAMLESS, SeamlessBlockMetadataBuffer())
        register(BlockMetadataType.MULTIPLE_FACE, MultipleFaceBlockMetadataBuffer())

        LOGGER.info("Register {} metadataKeyValueBuffers", metadataKeyByName.size)*/
    }

    fun serialize(metadataKeyValueBucket: MetadataKeyValueBucket): CompoundBinaryTag {
        val compoundBinaryTag = CompoundBinaryTag()
        for (metadataKeyValue in metadataKeyValueBucket.metadataKeyValues) {
            val metadataKeyValueBuffer = metadataKeyValueBuffer[metadataKeyValue.metadataKey]?: continue
            compoundBinaryTag.putBinaryTag(
                metadataKeyValue.metadataKey.name, metadataKeyValueBuffer.write(metadataKeyValue)
            )
        }
        return compoundBinaryTag
    }

    fun deserialize(compoundBinaryTag: CompoundBinaryTag): MetadataKeyValueBucket {
        val metadataKeyValueBucket = MetadataKeyValueBucket()
        compoundBinaryTag.value.forEach { (s: String, binaryTag: BinaryTag<*>?) ->
            val metadataKeyValueBuffer = metadataKeyValueBuffer[metadataKeyByName[s]]
            if (metadataKeyValueBuffer != null) {
                val metadataKeyValue = metadataKeyValueBuffer.read(binaryTag)
                metadataKeyValueBucket.setMetadataKeyValue(metadataKeyValue)
            }
        }
        return metadataKeyValueBucket
    }

    fun <K : MetadataKey> register(metadataKey: K, metadataKeyValueBuffer: MetadataKeyValueBuffer) {
        metadataKeyByName[metadataKey.name] = metadataKey
        this.metadataKeyValueBuffer[metadataKey] = metadataKeyValueBuffer
        LOGGER.debug("Register $metadataKey")
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MetadataKeyValueBufferRegistry::class.java)
    }
}