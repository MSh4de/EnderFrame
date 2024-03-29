package eu.mshade.enderframe.world.chunk

import eu.mshade.enderframe.world.block.Block

class Palette: Cloneable{

    val blockById = mutableMapOf<Int, Block>()
    private val idByBlock = mutableMapOf<Block, Int>()
    private val countBlock = mutableMapOf<Int, Int>();

    fun setBlock(id: Int, block: Block) {
        blockById[id] = block
        idByBlock[block] = id
    }

    //setBlock with count
    fun setBlock(id: Int, count: Int, block: Block) {
        blockById[id] = block
        idByBlock[block] = id
        countBlock[id] = count
    }

    //delete block from palette
    fun deleteBlock(id: Int) {
        idByBlock.remove(blockById.remove(id))
        countBlock.remove(id)
    }

    //get id of block
    fun getId(block: Block): Int? {
        return idByBlock[block]
    }

    fun getBlock(id: Int): Block? {
        return blockById[id]
    }

    //add count block
    fun addCount(id: Int) {
        countBlock[id] = countBlock.getOrDefault(id, 0) + 1
    }

    //remove count block
    fun removeCount(id: Int) {
        countBlock[id] = countBlock.getOrDefault(id, 0) - 1
    }

    //get count block
    fun getCount(id: Int): Int {
        return countBlock.getOrDefault(id, 0)
    }

    //get all block
    fun getBlock(): MutableCollection<Block> {
        return blockById.values
    }

    public override fun clone(): Palette {
        val palette = Palette()
        for (id in blockById.keys) {
            palette.setBlock(id, countBlock[id]!!, blockById[id]!!.clone())
        }
        return palette
    }

    override fun toString(): String {
        return "Palette(idByBlock=$idByBlock)"
    }



}