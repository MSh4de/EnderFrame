package eu.mshade.enderframe.metadata

import eu.mshade.mwork.binarytag.BinaryTag
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag
import org.slf4j.LoggerFactory

class MetadataKeyValueBufferRegistry {

    private val metadataKeyByName: MutableMap<String, MetadataKey> = HashMap()
    private val metadataKeyValueBuffer: MutableMap<MetadataKey, MetadataKeyValueBuffer> = HashMap()

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