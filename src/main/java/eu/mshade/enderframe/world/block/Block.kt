package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import kotlin.math.max

data class Block(private val materialKey: MaterialKey, private val metadataKeyValueBucket: MetadataKeyValueBucket = MetadataKeyValueBucket()): Cloneable {

    fun getMaterial(): MaterialKey {
        return materialKey
    }

    fun getMetadatas(): MetadataKeyValueBucket {
        return metadataKeyValueBucket
    }

    fun getRedstoneState(): RedstoneState {
        return metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.REDSTONE_STATE)?.metadataValue as? RedstoneState ?: RedstoneState.NONE
    }

    fun getFace(): BlockFace {
        return metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.FACE)?.metadataValue as? BlockFace ?: BlockFace.NONE
    }


    fun isTickable(): Boolean {
        return metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.TICKABLE)?.metadataValue as? Boolean ?: false
    }

    fun getTick(): Int {
        return metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.TICK)?.metadataValue as? Int ?: 0
    }

    fun getPower(): Int {
        val power = metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.POWER)?.metadataValue as? Int ?: 0
        return max(power, 0)
    }

    fun hasPower(): Boolean {
        return getPower() > 0
    }

    fun modifyTick(modifier: (Int) -> Int) {
        val tick = getTick()
        metadataKeyValueBucket.setMetadataKeyValue(TickBlockMetadata(modifier(tick)))
    }

    fun resetTick() {
        metadataKeyValueBucket.setMetadataKeyValue(TickBlockMetadata(0))
    }

    fun isLocked(): Boolean {
        return metadataKeyValueBucket.getMetadataKeyValue(BlockMetadataType.LOCKED)?.metadataValue as? Boolean ?: false
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Block) return false

        if (materialKey != other.materialKey) return false
        return metadataKeyValueBucket == other.metadataKeyValueBucket
    }

    override fun hashCode(): Int {
        var result = materialKey.hashCode()
        result = 31 * result + metadataKeyValueBucket.hashCode()
        return result
    }

    public override fun clone(): Block {
        return Block(materialKey, metadataKeyValueBucket.clone())
    }
}
