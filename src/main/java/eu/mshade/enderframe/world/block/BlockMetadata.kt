package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag

object BlockMetadataType {

    val LIGHT: MetadataKey = MetadataKey.from("BLOCK_LIGHT")
    val FACE: MetadataKey = MetadataKey.from("BLOCK_FACE")
    val EXTRA: MetadataKey = MetadataKey.from("BLOCK_EXTRA")

}

class LightBlockMetadata(light: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.LIGHT, light)

class FaceBlockMetadata(blockFace: BlockFace): MetadataKeyValue<BlockFace>(BlockMetadataType.FACE, blockFace)

class ExtraBlockMetadata(extra: CompoundBinaryTag): MetadataKeyValue<CompoundBinaryTag>(BlockMetadataType.EXTRA, extra)



