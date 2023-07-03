package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.wrapper.MaterialKeyWrapper
import eu.mshade.enderframe.wrapper.MaterialWrapperContext

abstract class BlockTransformer {

    abstract fun transform(block: Block, materialWrapper: MaterialKeyWrapper): MaterialKey?

    abstract fun transform(material: MaterialKey, materialWrapper: MaterialKeyWrapper): Block?

    abstract fun canTransform(material: MaterialKey): Boolean

}

class BlockTransformerController(private val materialWrapper: MaterialKeyWrapper) {

    private val blockTransformers = mutableListOf<BlockTransformer>()
    private val commonBlockTransformer = CommonBlockTransformer()

    fun register(blockTransformer: BlockTransformer) {
        blockTransformers.add(blockTransformer)
    }

    //server side
    fun transform(block: Block): MaterialKey? {
        val materialKey = block.getMaterial()
        val blockTransformer = getBlockTransformer(materialKey)
            ?: commonBlockTransformer

        return blockTransformer.transform(block, materialWrapper)
    }

    //client side
    fun reverse(materialKey: MaterialKey): Block? {
        val reverseMaterial =
            materialWrapper.reverseMap(MaterialWrapperContext.BLOCK, MaterialKey.from(materialKey.id))?: return null

        val blockTransformer = getBlockTransformer(reverseMaterial)?: commonBlockTransformer
        return blockTransformer.transform(materialKey, materialWrapper)
    }


    private fun getBlockTransformer(materialKey: MaterialKey): BlockTransformer? {
        var blockTransformer: BlockTransformer? = null

        for (transformer in blockTransformers) {
            if (transformer.canTransform(materialKey)) {
                if (blockTransformer != null) {
                    throw IllegalStateException("Multiple block transformer found for ${materialKey.namespacedKey} (${blockTransformer.javaClass.name}, ${transformer.javaClass.name})")
                }
                blockTransformer = transformer
            }
        }

        return blockTransformer
    }
}

class CommonBlockTransformer : BlockTransformer() {

    override fun transform(block: Block, materialWrapper: MaterialKeyWrapper): MaterialKey? {
        return materialWrapper.map(MaterialWrapperContext.BLOCK, block.getMaterial())
    }

    override fun transform(material: MaterialKey, materialWrapper: MaterialKeyWrapper): Block? {
        return materialWrapper.reverseMap(MaterialWrapperContext.BLOCK, material)?.toBlock()
    }

    override fun canTransform(material: MaterialKey): Boolean {
        return true
    }

}


