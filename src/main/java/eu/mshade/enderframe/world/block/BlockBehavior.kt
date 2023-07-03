package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World

interface BlockBehavior {

    fun place(
        player: Player,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector = Vector.ZERO,
        material: MaterialKey
    ): Collection<Pair<Vector, Block>> {
        val blocks = mutableListOf<Pair<Vector, Block>>()
        val block = material.toBlock()

        blocks.add(Pair(blockPosition, block))

        return blocks
    }

    fun interact(
        player: Player,
        blockPosition: Vector,
        blockFace: BlockFace,
        cursorPosition: Vector = Vector.ZERO,
        block: Block,
        tickableBlocks: TickableBlockRepository
    ) {
        TODO("Not yet implemented")
    }

    fun updateBlock(world: World, position: Vector, previousPosition: Vector, tickableBlocks: TickableBlockRepository) {

    }

/*    fun updateBlock(position: Vector, world: World, block: Block, power: Int,
                    source: Vector,
                    tickableBlocks: TickableBlockRepository
    ) {

    }*/

    fun updateClientBlock(world: World, blocks: Collection<Pair<Vector, Block>>) {
        for ((position, block) in blocks) {
            val chunk = world.getChunk(position.blockX shr 4, position.blockZ shr 4)?.get() ?: continue
            chunk.notify(Player::class.java) { it.minecraftSession.sendBlockChange(position, block) }
        }
    }

    fun canApply(material: MaterialKey): Boolean

}


class BlockBehaviorRepository {

    private val blockBehaviors = mutableListOf<BlockBehavior>()

    fun register(blockBehavior: BlockBehavior) {
        blockBehaviors.add(blockBehavior)
    }

    fun getBlockBehavior(material: MaterialKey): BlockBehavior? {
        var blockBehavior: BlockBehavior? = null

        for (rule in blockBehaviors) {
            if (rule.canApply(material)) {
                if (blockBehavior != null) {
                    throw IllegalStateException("Multiple block rules found for ${material.namespacedKey.key}, ${blockBehavior.javaClass.name} and ${rule.javaClass.name}")
                }
                blockBehavior = rule
            }
        }

        return blockBehavior
    }

}