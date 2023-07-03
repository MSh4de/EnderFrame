package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.inventory.Inventory
import eu.mshade.enderframe.inventory.NamedInventory
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.world.Vector
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

object BlockMetadataType {

    private val PREFIX = "BLOCK"

    val FACE: MetadataKey = MetadataKey.from("${PREFIX}_FACE")
    val EXTRA: MetadataKey = MetadataKey.from("${PREFIX}_EXTRA")
    val HALF: MetadataKey = MetadataKey.from("${PREFIX}_HALF")
    val SLAB_TYPE: MetadataKey = MetadataKey.from("${PREFIX}_SLAB_TYPE")
    val SHAPE: MetadataKey = MetadataKey.from("${PREFIX}_SHAPE")
    val AXIS: MetadataKey = MetadataKey.from("${PREFIX}_AXIS")
    val POWER: MetadataKey = MetadataKey.from("${PREFIX}_POWER")
    val DELAY: MetadataKey = MetadataKey.from("${PREFIX}_DELAY")
    val TICKABLE: MetadataKey = MetadataKey.from("${PREFIX}_TICKABLE")
    val TICK: MetadataKey = MetadataKey.from("${PREFIX}_TICK")
    val DECAYABLE: MetadataKey = MetadataKey.from("${PREFIX}_DECAYABLE")
    val CHECK_DECAY: MetadataKey = MetadataKey.from("${PREFIX}_CHECK_DECAY")
    val SEAMLESS: MetadataKey = MetadataKey.from("${PREFIX}_SEAMLESS")

    val REDSTONE_STATE: MetadataKey = MetadataKey.from("${PREFIX}_REDSTONE_STATE")
    val POWER_SOURCE: MetadataKey = MetadataKey.from("${PREFIX}_POWER_SOURCE")
    val LOCKED: MetadataKey = MetadataKey.from("${PREFIX}_LOCKED")

    val MULTIPLE_FACE: MetadataKey = MetadataKey.from("${PREFIX}_MULTIPLE_FACE")
    val INVENTORY: MetadataKey = MetadataKey.from("${PREFIX}_INVENTORY")


}

class FaceBlockMetadata(blockFace: BlockFace) : MetadataKeyValue<BlockFace>(BlockMetadataType.FACE, blockFace) {

    override fun clone(): MetadataKeyValue<BlockFace> {
        return FaceBlockMetadata(metadataValue)
    }
}

class HalfBlockMetadata(blockHalf: BlockHalf) : MetadataKeyValue<BlockHalf>(BlockMetadataType.HALF, blockHalf) {

    override fun clone(): MetadataKeyValue<BlockHalf> {
        return HalfBlockMetadata(metadataValue)
    }
}

class ShapeBlockMetadata(blockShape: BlockShape) : MetadataKeyValue<BlockShape>(BlockMetadataType.SHAPE, blockShape) {

    override fun clone(): MetadataKeyValue<BlockShape> {
        return ShapeBlockMetadata(metadataValue)
    }
}

class ExtraBlockMetadata(extra: CompoundBinaryTag) :
    MetadataKeyValue<CompoundBinaryTag>(BlockMetadataType.EXTRA, extra) {

    override fun clone(): MetadataKeyValue<CompoundBinaryTag> {
        return ExtraBlockMetadata(metadataValue.clone())
    }
}

class AxisBlockMetadata(blockAxis: BlockAxis) : MetadataKeyValue<BlockAxis>(BlockMetadataType.AXIS, blockAxis) {

    override fun clone(): MetadataKeyValue<BlockAxis> {
        return AxisBlockMetadata(metadataValue)
    }
}

class PowerBlockMetadata(power: Int) : MetadataKeyValue<Int>(BlockMetadataType.POWER, power) {
    constructor(boolean: Boolean) : this(if (boolean) 15 else 0)

    override fun clone(): MetadataKeyValue<Int> {
        return PowerBlockMetadata(metadataValue)
    }
}

class DelayBlockMetadata(delay: Int) : MetadataKeyValue<Int>(BlockMetadataType.DELAY, delay) {

    override fun clone(): MetadataKeyValue<Int> {
        return DelayBlockMetadata(metadataValue)
    }
}

class DecayableBlockMetadata(decayable: Boolean) : MetadataKeyValue<Boolean>(BlockMetadataType.DECAYABLE, decayable) {

    override fun clone(): MetadataKeyValue<Boolean> {
        return DecayableBlockMetadata(metadataValue)
    }
}

class CheckDecayBlockMetadata(checkDecay: Boolean) :
    MetadataKeyValue<Boolean>(BlockMetadataType.CHECK_DECAY, checkDecay) {

    override fun clone(): MetadataKeyValue<Boolean> {
        return CheckDecayBlockMetadata(metadataValue)
    }
}

class SeamlessBlockMetadata(seamless: Boolean) : MetadataKeyValue<Boolean>(BlockMetadataType.SEAMLESS, seamless) {

    override fun clone(): MetadataKeyValue<Boolean> {
        return SeamlessBlockMetadata(metadataValue)
    }
}

class MultipleFaceBlockMetadata(multipleFace: MutableSet<BlockFace> = mutableSetOf()) :
    MetadataKeyValue<MutableSet<BlockFace>>(BlockMetadataType.MULTIPLE_FACE, multipleFace) {

    override fun clone(): MetadataKeyValue<MutableSet<BlockFace>> {
        return MultipleFaceBlockMetadata(metadataValue.toMutableSet())
    }
}

class SlabTypeBlockMetadata(slabType: SlabType) : MetadataKeyValue<SlabType>(BlockMetadataType.SLAB_TYPE, slabType) {

    override fun clone(): MetadataKeyValue<SlabType> {
        return SlabTypeBlockMetadata(metadataValue)
    }
}

class InventoryBlockMetadata(inventory: Inventory) : MetadataKeyValue<Inventory>(BlockMetadataType.INVENTORY, inventory)

class TickableBlockMetadata(tickable: Boolean) : MetadataKeyValue<Boolean>(BlockMetadataType.TICKABLE, tickable) {

    override fun clone(): MetadataKeyValue<Boolean> {
        return TickableBlockMetadata(metadataValue)
    }
}

class TickBlockMetadata(tick: Int) : MetadataKeyValue<Int>(BlockMetadataType.TICK, tick) {

    override fun clone(): MetadataKeyValue<Int> {
        return TickBlockMetadata(metadataValue)
    }
}

class RedstoneStateBlockMetadata(redstoneState: RedstoneState) :
    MetadataKeyValue<RedstoneState>(BlockMetadataType.REDSTONE_STATE, redstoneState) {

    override fun clone(): MetadataKeyValue<RedstoneState> {
        return RedstoneStateBlockMetadata(metadataValue)
    }
}

class LockedBlockMetadata(locked: Boolean) : MetadataKeyValue<Boolean>(BlockMetadataType.LOCKED, locked) {

    override fun clone(): MetadataKeyValue<Boolean> {
        return LockedBlockMetadata(metadataValue)
    }
}

class PowerSourceBlockMetadata(powerSources : MutableSet<Vector> = mutableSetOf()) : MetadataKeyValue<MutableSet<Vector>>(BlockMetadataType.POWER_SOURCE, powerSources) {

    override fun clone(): MetadataKeyValue<MutableSet<Vector>> {
        return PowerSourceBlockMetadata(metadataValue.toMutableSet())
    }
}





