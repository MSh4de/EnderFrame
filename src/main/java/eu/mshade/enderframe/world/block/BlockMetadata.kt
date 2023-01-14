package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.Flushable
import eu.mshade.enderframe.inventory.InventoryRepository
import eu.mshade.enderframe.inventory.NamedInventory
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

object BlockMetadataType {

    val FACE: MetadataKey = MetadataKey.from("BLOCK_FACE")
    val EXTRA: MetadataKey = MetadataKey.from("BLOCK_EXTRA")
    val HALF : MetadataKey = MetadataKey.from("BLOCK_HALF")
    val SHAPE: MetadataKey = MetadataKey.from("BLOCK_SHAPE")
    val AXIS: MetadataKey = MetadataKey.from("BLOCK_AXIS")
    val POWER: MetadataKey = MetadataKey.from("BLOCK_POWER")
    val POWERED: MetadataKey = MetadataKey.from("BLOCK_POWERED")
    val DECAYABLE: MetadataKey = MetadataKey.from("BLOCK_DECAYABLE")
    val CHECK_DECAY: MetadataKey = MetadataKey.from("BLOCK_CHECK_DECAY")
    val SEAMLESS: MetadataKey = MetadataKey.from("BLOCK_SEAMLESS")

    val MULTIPLE_FACE: MetadataKey = MetadataKey.from("BLOCK_MULTIPLE_FACE")
    val INVENTORY: MetadataKey = MetadataKey.from("BLOCK_INVENTORY")


}

class FaceBlockMetadata(blockFace: BlockFace): MetadataKeyValue<BlockFace>(BlockMetadataType.FACE, blockFace)

class HalfBlockMetadata(blockHalf: BlockHalf): MetadataKeyValue<BlockHalf>(BlockMetadataType.HALF, blockHalf)

class ShapeBlockMetadata(blockShape: BlockShape): MetadataKeyValue<BlockShape>(BlockMetadataType.SHAPE, blockShape)

class ExtraBlockMetadata(extra: CompoundBinaryTag): MetadataKeyValue<CompoundBinaryTag>(BlockMetadataType.EXTRA, extra)

class AxisBlockMetadata(blockAxis: BlockAxis): MetadataKeyValue<BlockAxis>(BlockMetadataType.AXIS, blockAxis)

class PoweredBlockMetadata(powered: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.POWERED, powered)

class PowerBlockMetadata(power: Int): MetadataKeyValue<Int>(BlockMetadataType.POWER, power)

class DecayableBlockMetadata(decayable: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.DECAYABLE, decayable)

class CheckDecayBlockMetadata(checkDecay: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.CHECK_DECAY, checkDecay)

class SeamlessBlockMetadata(seamless: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.SEAMLESS, seamless)

class MultipleFaceBlockMetadata(multipleFace: MutableSet<BlockFace> = mutableSetOf()): MetadataKeyValue<MutableSet<BlockFace>>(BlockMetadataType.MULTIPLE_FACE, multipleFace)

class InventoryBlockMetadata(inventory: NamedInventory): MetadataKeyValue<NamedInventory>(BlockMetadataType.INVENTORY, inventory)





