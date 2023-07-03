package eu.mshade.enderframe.world.chunk

import eu.mshade.enderframe.Agent
import eu.mshade.enderframe.Watchable
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.item.Material
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.block.Block
import eu.mshade.enderframe.world.block.BlockBehaviorRepository
import eu.mshade.enderframe.world.block.TickableBlockRepository
import java.util.*
import java.util.concurrent.ConcurrentLinkedQueue

abstract class Chunk(val x: Int, val z: Int, val world: World) : Watchable {

    companion object {
        const val WIDTH = 16
        const val HEIGHT = 16
        const val DEPTH = 256
        const val SEC_DEPTH = 16

        fun key(x: Int, z: Int): Long {
            return x.toLong() and 0xffffffffL shl 32 or (z.toLong() and 0xffffffffL)
        }
    }

    val id: Long = key(x, z)
    val sections = arrayOfNulls<Section>(16)

    val entities = ConcurrentLinkedQueue<Entity>()
    val chunkStateStore = ChunkStateStore()

    val agent = Agent.from("Chunk{$x,$z}")

    val isSectionsEmpty: Boolean
        get() {
            for (section in sections) {
                if (section != null) return false
            }
            return true
        }

    val paletteBlock: Collection<Block>
        get() {
            val blocks: MutableCollection<Block> = ArrayList()
            for (section in sections) {
                if (section == null) continue
                for (block in section.getPalette().getBlocks()) {
                    if (blocks.contains(block.block)) continue
                    blocks.add(block.block)
                }
            }
            return blocks
        }

    val bitMask: Int
        get() {
            var sectionBitmask = 0
            for (i in sections.indices) {
                val section = sections[i]
                if (section != null && section.realBlock != 0) {
                    sectionBitmask = sectionBitmask or (1 shl i)
                }
            }
            return sectionBitmask
        }

    abstract fun getBlock(x: Int, y: Int, z: Int): Block

    abstract fun setBlock(x: Int, y: Int, z: Int, block: Block)

    fun setBlock(x: Int, y: Int, z: Int, material: MaterialKey) {
        setBlock(x, y, z, material.toBlock())
    }

    fun setBlock(vector: Vector, block: Block) {
        setBlock(vector.blockX, vector.blockY, vector.blockZ, block)
    }

    abstract fun getBlockLight(x: Int, y: Int, z: Int): Byte

    abstract fun setBlockLight(x: Int, y: Int, z: Int, light: Byte)

    abstract fun getSkyLight(x: Int, y: Int, z: Int): Byte

    abstract fun setSkyLight(x: Int, y: Int, z: Int, light: Byte)

    abstract fun setBiome(x: Int, z: Int, biome: Int)

    abstract fun getBiome(x: Int, z: Int): Int

    abstract fun getSectionOrCreate(y: Int): Section

    fun getSection(y: Int): Section? {
        return sections[y]
    }

    fun hasSection(y: Int): Boolean {
        return getSection(y) != null
    }

    abstract fun createSection(y: Int): Section

    abstract var biomes: ByteArray

    fun getHighest(x: Int, z: Int): Int {
        for (i in 255 downTo 1) {
            if (getBlock(x, i, z).getMaterial() !== Material.AIR) {
                return i
            }
        }
        return 0
    }

    fun getBiomeIndex(x: Int, z: Int): Int {
        return (z and 0xF) * WIDTH + (x and 0xF)
    }

    fun getBlockIndex(x: Int, y: Int, z: Int): Int {
        return y and 0xf shl 8 or (z and 0x0f shl 4) or (x and 0x0f)
    }

    fun getVectorFromIndex(index: Int): Vector {
        return Vector(index and 0xf, index shr 8 and 0xf, index shr 4 and 0xf)
    }
}
