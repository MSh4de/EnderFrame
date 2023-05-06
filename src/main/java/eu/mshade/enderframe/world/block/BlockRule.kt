package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.item.MaterialCategoryKey
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.block.BlockMetadataType.MULTIPLE_FACE

abstract class BlockRule {

    abstract fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector = Vector.ZERO,
        block: Block
    ): Block?

}


class BlockRuleRepository {

    private val blockRuleByMaterialKey = mutableMapOf<MaterialCategoryKey, BlockRule>()

    fun register(materialCategoryKey: MaterialCategoryKey, blockRule: BlockRule) {
        blockRuleByMaterialKey[materialCategoryKey] = blockRule
    }

    fun getBlockRule(materialCategoryKey: MaterialCategoryKey): BlockRule? {
        return blockRuleByMaterialKey[materialCategoryKey]
    }

}

class StairsBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        val direction = BlockFace.fromDirection(pov.yaw)
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(direction))
        metadataKeyValueBucket.setMetadataKeyValue(HalfBlockMetadata(BlockHalf.fromY(cursorPosition.y)))
        return block
    }


}

class LogBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()

        metadataKeyValueBucket.setMetadataKeyValue(
            AxisBlockMetadata(
                blockFace.toAxis()
            )
        )
        return block
    }

}

class ButtonBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(blockFace))
        metadataKeyValueBucket.setMetadataKeyValue(PoweredBlockMetadata(false))
        return block
    }

}

class LeverBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(blockFace))
        metadataKeyValueBucket.setMetadataKeyValue(PoweredBlockMetadata(false))
        metadataKeyValueBucket.setMetadataKeyValue(
            AxisBlockMetadata(
                BlockFace.fromDirection(pov.yaw).toAxis()
            )
        )
        return block
    }

}

class SlabBlockRule : BlockRule() {

    private val slabToDoubleSlab = mutableMapOf<MaterialKey, MaterialKey>()

    init {
        //register slab to double slab
/*        slabToDoubleSlab[Material.STONE_SLAB] = Material.DOUBLE_STONE_SLAB
        slabToDoubleSlab[Material.SANDSTONE_SLAB] = Material.DOUBLE_SANDSTONE_SLAB
        slabToDoubleSlab[Material.COBBLESTONE_SLAB] = Material.DOUBLE_COBBLESTONE_SLAB
        slabToDoubleSlab[Material.BRICK_SLAB] = Material.DOUBLE_BRICK_SLAB
        slabToDoubleSlab[Material.STONE_BRICK_SLAB] = Material.DOUBLE_STONE_BRICK_SLAB
        slabToDoubleSlab[Material.NETHER_BRICK_SLAB] = Material.DOUBLE_NETHER_BRICK_SLAB
        slabToDoubleSlab[Material.QUARTZ_SLAB] = Material.DOUBLE_QUARTZ_SLAB
        slabToDoubleSlab[Material.OAK_SLAB] = Material.DOUBLE_OAK_SLAB
        slabToDoubleSlab[Material.SPRUCE_SLAB] = Material.DOUBLE_SPRUCE_SLAB
        slabToDoubleSlab[Material.BIRCH_SLAB] = Material.DOUBLE_BIRCH_SLAB
        slabToDoubleSlab[Material.JUNGLE_SLAB] = Material.DOUBLE_JUNGLE_SLAB
        slabToDoubleSlab[Material.ACACIA_SLAB] = Material.DOUBLE_ACACIA_SLAB
        slabToDoubleSlab[Material.DARK_OAK_SLAB] = Material.DOUBLE_DARK_OAK_SLAB
        slabToDoubleSlab[Material.PURPUR_SLAB] = Material.DOUBLE_PURPUR_SLAB
        slabToDoubleSlab[Material.PRISMARINE_SLAB] = Material.DOUBLE_PRISMARINE_SLAB
        slabToDoubleSlab[Material.PRISMARINE_BRICK_SLAB] = Material.DOUBLE_PRISMARINE_BRICK_SLAB*/

    }

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        val blockHalf = BlockHalf.fromY(cursorPosition.y)

        var slabType: SlabType? = null
        if (blockHalf == BlockHalf.TOP) slabType = SlabType.TOP
        else if (blockHalf == BlockHalf.BOTTOM) slabType = SlabType.BOTTOM

        metadataKeyValueBucket.setMetadataKeyValue(SlabTypeBlockMetadata(slabType!!))

        val oppositeBlock = pov.world.getBlock(blockPosition.clone().add(blockFace.oppositeFace.vector))
        val previousBlock = pov.world.getBlock(blockPosition)

        if ((blockFace == BlockFace.UP || blockFace == BlockFace.DOWN)) {
            if (oppositeBlock.getMaterialKey() == block.getMaterialKey()) {
                blockPosition.add(blockFace.oppositeFace.vector)
                metadataKeyValueBucket.setMetadataKeyValue(SlabTypeBlockMetadata(SlabType.DOUBLE))
            }else {
                if (previousBlock.getMaterialKey() == block.getMaterialKey()) {
                    metadataKeyValueBucket.setMetadataKeyValue(SlabTypeBlockMetadata(SlabType.DOUBLE))
                }else {
                    metadataKeyValueBucket.setMetadataKeyValue(SlabTypeBlockMetadata(SlabType.BOTTOM))
                }
            }
        }else if (previousBlock.getMaterialKey() == block.getMaterialKey()) {
            metadataKeyValueBucket.setMetadataKeyValue(SlabTypeBlockMetadata(SlabType.DOUBLE))
        }

        if (previousBlock.getMaterialKey() == Material.AIR) return block

        return block
    }


}

class VineBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ): Block {
        val previousBlock = pov.world.getBlock(blockPosition)

        val vineBlock : Block = if (previousBlock.getMaterialKey() == Material.VINE){
            previousBlock
        }else {
            block
        }

        val metadataKeyValueBucket = vineBlock.getMetadataKeyValueBucket()
        var metadataKeyValue = metadataKeyValueBucket.getMetadataKeyValue(MULTIPLE_FACE) as? MultipleFaceBlockMetadata

        if (metadataKeyValue == null) {
            metadataKeyValue = MultipleFaceBlockMetadata()
            metadataKeyValueBucket.setMetadataKeyValue(metadataKeyValue)
        }

        metadataKeyValue.metadataValue.add(blockFace)

        return vineBlock
    }

}