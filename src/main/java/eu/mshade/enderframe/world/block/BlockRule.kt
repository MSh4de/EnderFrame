package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector

interface BlockRule {

    fun apply(
        pov: Location,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector = Vector.ZERO,
        block: Block
    ): Block?

    fun canApply(material: MaterialKey): Boolean

}


class BlockRuleRepository {

    private val blockRules = mutableListOf<BlockRule>()

    fun register(blockRule: BlockRule) {
        blockRules.add(blockRule)
    }

    fun getBlockRule(materialKey: MaterialKey): BlockRule? {
        var blockRule: BlockRule? = null

        for (rule in blockRules) {
            if (rule.canApply(materialKey)) {
                if (blockRule != null) {
                    throw IllegalStateException("Multiple block rule found for ${materialKey.namespacedKey} (${blockRule.javaClass.name}, ${rule.javaClass.name})")
                }
                blockRule = rule
            }
        }

        return blockRule
    }

}