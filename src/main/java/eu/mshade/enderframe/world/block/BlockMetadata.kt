package eu.mshade.enderframe.world.block

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

}

class FaceBlockMetadata(blockFace: BlockFace): MetadataKeyValue<BlockFace>(BlockMetadataType.FACE, blockFace)

class HalfBlockMetadata(blockHalf: BlockHalf): MetadataKeyValue<BlockHalf>(BlockMetadataType.HALF, blockHalf)

class ShapeBlockMetadata(blockShape: BlockShape): MetadataKeyValue<BlockShape>(BlockMetadataType.SHAPE, blockShape)

class ExtraBlockMetadata(extra: CompoundBinaryTag): MetadataKeyValue<CompoundBinaryTag>(BlockMetadataType.EXTRA, extra)

class AxisBlockMetadata(blockAxis: BlockAxis): MetadataKeyValue<BlockAxis>(BlockMetadataType.AXIS, blockAxis)

class PoweredBlockMetadata(powered: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.POWERED, powered)



