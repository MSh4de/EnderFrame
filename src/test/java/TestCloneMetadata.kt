import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.block.Block
import eu.mshade.enderframe.world.block.BlockMetadataType
import eu.mshade.enderframe.world.block.PowerBlockMetadata

fun main() {

    var metadataKeyValueBucket = MetadataKeyValueBucket()
    metadataKeyValueBucket.setMetadataKeyValue(PowerBlockMetadata(1))
    var block = Block(Material.LEVER, metadataKeyValueBucket)

    var clone = block.clone()
    var metadatas = clone.getMetadatas()
    metadatas.setMetadataKeyValue(PowerBlockMetadata(2))

    println(block == clone)

}