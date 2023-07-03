package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.tick.Tickable
import eu.mshade.enderframe.world.ChunkStatus
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.chunk.Chunk
import java.util.concurrent.ConcurrentLinkedQueue


class TickableBlockRepository(val blockBehaviorRepository: BlockBehaviorRepository): Tickable(){

    val tickableBlockEntries = ConcurrentLinkedQueue<TickableBlockEntry>()

    override fun tick() {

        for (tickableBlock in ConcurrentLinkedQueue(tickableBlockEntries)) {
            val world = tickableBlock.world
            val chunk = getChunk(world, tickableBlock.position)
            if (chunk == null || chunk.chunkStateStore.chunkStatus != ChunkStatus.LOADED) continue
            if (!hasBlock(world, tickableBlock.position)) continue

            tickableBlockEntries.remove(tickableBlock)

            val block = world.getBlock(tickableBlock.position)

            blockBehaviorRepository.getBlockBehavior(block.getMaterial())
                ?.updateBlock(world, tickableBlock.position, tickableBlock.previousPosition, this)
        }


    }


    private fun getChunk(world: World, vector: Vector): Chunk? {
        val chunkX = vector.blockX shr 4
        val chunkZ = vector.blockZ shr 4

        return world.getChunk(chunkX, chunkZ)?.join()
    }

    fun join(world: World, position: Vector){
        join(world, position, position)
    }

    fun join(world: World, position: Vector, previousPosition: Vector){
        tickableBlockEntries.add(TickableBlockEntry(world, position, previousPosition))
    }

    fun leave(world: World, position: Vector){
        tickableBlockEntries.removeIf { it.position == position && it.world == world }
    }

    fun hasBlock(world: World, position: Vector): Boolean{
        return tickableBlockEntries.any { it.position == position && it.world == world }
    }

    fun flush(chunk: Chunk){
        for (tickableBlockEntry in tickableBlockEntries) {
            val tickableChunk = getChunk(tickableBlockEntry.world, tickableBlockEntry.position)
            if (tickableChunk == null || (tickableBlockEntry.world == chunk.world && chunk.id == tickableChunk.id)) {
                tickableBlockEntries.remove(tickableBlockEntry)
            }
        }
    }
}

data class TickableBlockEntry(val world: World, val position: Vector, val previousPosition: Vector)