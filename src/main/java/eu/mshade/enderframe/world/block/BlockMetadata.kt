package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

object BlockMetadataType {

    val LIGHT: MetadataKey = MetadataKey.from("LIGHT")
    val FACE: MetadataKey = MetadataKey.from("FACE")

}

class LightBlockMetadata(light: Boolean): MetadataKeyValue<Boolean>(BlockMetadataType.LIGHT, light)

class FaceBlockMetadata(blockFace: BlockFace): MetadataKeyValue<BlockFace>(BlockMetadataType.FACE, blockFace)



