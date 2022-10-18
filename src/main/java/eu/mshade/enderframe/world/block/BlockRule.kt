package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialCategoryKey
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import eu.mshade.mwork.binarytag.entity.CompoundBinaryTag
import java.util.*

abstract class BlockRule {

    abstract fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector = Vector.ZERO,
        block: Block
    )

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
    ) {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        val direction = BlockFace.fromDirection(pov.yaw)
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(direction))
        metadataKeyValueBucket.setMetadataKeyValue(HalfBlockMetadata(BlockHalf.fromY(cursorPosition.y)))
    }

}

class LogBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ) {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()

        metadataKeyValueBucket.setMetadataKeyValue(
            AxisBlockMetadata(
                blockFace.toAxis()
            )
        )
    }

}

class ButtonBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ) {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(blockFace))
        metadataKeyValueBucket.setMetadataKeyValue(PoweredBlockMetadata(false))
    }

}

class LeverBlockRule : BlockRule() {

    override fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector,
        block: Block
    ) {
        val metadataKeyValueBucket = block.getMetadataKeyValueBucket()
        metadataKeyValueBucket.setMetadataKeyValue(FaceBlockMetadata(blockFace))
        metadataKeyValueBucket.setMetadataKeyValue(PoweredBlockMetadata(false))
        metadataKeyValueBucket.setMetadataKeyValue(
            AxisBlockMetadata(
                BlockFace.fromDirection(pov.yaw).toAxis()
            )
        )

        println("axis: ${BlockFace.fromDirection(pov.yaw).toAxis()}")
    }

}