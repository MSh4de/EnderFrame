package eu.mshade.enderframe.world.chunk

import eu.mshade.enderframe.world.block.Block
import java.util.concurrent.ConcurrentLinkedQueue

class Palette: Cloneable {

    private val blocks = ConcurrentLinkedQueue<PaletteEntry>()

    fun setBlock(id: Int, block: Block, count: Int = 1) {
        blocks.add(PaletteEntry(id, block, count))
    }

    fun hasBlock(block: Block): Boolean {
        return blocks.any { it.block == block }
    }

    fun getBlock(id: Int): Block? {
        return blocks.firstOrNull { it.id == id }?.block
    }

    fun modifyCount(block: Block, modifier: (Int) -> Int) {
        val entry = blocks.firstOrNull { it.block == block }
        if (entry != null) {
            entry.count = modifier(entry.count)
        }
    }

    fun getCount(block: Block): Int? {
        return blocks.firstOrNull { it.block == block }?.count
    }

    fun deleteBlock(block: Block) {
        blocks.removeIf { it.block == block }
    }

    fun getBlockEntry(block: Block): PaletteEntry? {
        return blocks.firstOrNull { it.block == block }
    }

    fun getBlocks(): Collection<PaletteEntry>{
        return blocks
    }

    public override fun clone(): Palette {
        val palette = Palette()
        palette.blocks.addAll(blocks.map { it.clone() })
        return palette
    }

}

data class PaletteEntry(val id: Int, val block: Block, var count: Int): Cloneable {

    public override fun clone(): PaletteEntry {
        return PaletteEntry(id, block.clone(), count)
    }

}


