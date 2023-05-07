package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialCategory
import eu.mshade.enderframe.item.MaterialCategoryKey
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.wrapper.MaterialKeyWrapper
import eu.mshade.enderframe.wrapper.MaterialWrapperContext
import eu.mshade.enderframe.wrapper.Wrapper

abstract class BlockTransformer {

    abstract fun transform(block: Block, materialWrapper: MaterialKeyWrapper): MaterialKey?

    abstract fun transform(materialKey: MaterialKey, materialWrapper: MaterialKeyWrapper): Block?

    abstract fun getTag(): MaterialCategoryKey

}

class BlockTransformerController(private val materialWrapper: MaterialKeyWrapper) {

    private val transformerByMaterialKey = mutableMapOf<MaterialCategoryKey, BlockTransformer>()

    fun register(blockTransformer: BlockTransformer) {
        transformerByMaterialKey[blockTransformer.getTag()] = blockTransformer
    }

    //server side
    fun transform(block: Block): MaterialKey? {
        val materialKey = block.getMaterialKey()
        val blockTransformer = transformerByMaterialKey[materialKey.tag] ?: transformerByMaterialKey[MaterialCategory.DEFAULT]
        return blockTransformer?.transform(block, materialWrapper)
    }

    //client side
    fun reverse(materialKey: MaterialKey): Block? {
        val reverseMaterial = materialWrapper.reverseMap(MaterialWrapperContext.BLOCK, MaterialKey.from(materialKey.id))?: return null
        val blockTransformer = transformerByMaterialKey[reverseMaterial.tag] ?: transformerByMaterialKey[MaterialCategory.DEFAULT]
        return blockTransformer?.transform(materialKey, materialWrapper)
    }


}


