package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.chunk.Section

class Block(private val materialKey: MaterialKey, private val metadataKeyValueBucket: MetadataKeyValueBucket = MetadataKeyValueBucket()): Cloneable {

    fun getMaterialKey(): MaterialKey {
        return materialKey
    }

    fun getMetadataKeyValueBucket(): MetadataKeyValueBucket {
        return metadataKeyValueBucket
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Block

        if (materialKey != other.materialKey) return false
        if (metadataKeyValueBucket != other.metadataKeyValueBucket) return false

        return true
    }

    override fun hashCode(): Int {
        var result = materialKey.hashCode()
        result = 31 * result + metadataKeyValueBucket.hashCode()
        return result
    }

    override fun toString(): String {
        return "Block(materialKey=$materialKey, metadataKeyValueBucket=$metadataKeyValueBucket)"
    }

    public override fun clone(): Block {
        return Block(materialKey, metadataKeyValueBucket.clone())
    }
}
