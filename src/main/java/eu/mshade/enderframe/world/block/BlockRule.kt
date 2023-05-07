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