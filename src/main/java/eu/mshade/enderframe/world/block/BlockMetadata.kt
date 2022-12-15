package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.world.block.window.IWindowProperty
import eu.mshade.enderframe.world.block.window.WindowType
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
    val WINDOW_TYPE: MetadataKey = MetadataKey.from("BLOCK_WINDOW_TYPE")
    val WINDOW_PROPERTY: MetadataKey = MetadataKey.from("BLOCK_WINDOW_PROPERTY")
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

class WindowTypeMetadata(windowType: WindowType): MetadataKeyValue<WindowType>(BlockMetadataType.WINDOW_TYPE, windowType)

class WindowPropertyMetadata(windowProperty: IWindowProperty): MetadataKeyValue<IWindowProperty>(BlockMetadataType.WINDOW_PROPERTY, windowProperty)