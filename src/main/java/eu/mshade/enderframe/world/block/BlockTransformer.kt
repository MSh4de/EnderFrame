package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialCategoryKey
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.wrapper.Wrapper

abstract class BlockTransformer {

    abstract fun transform(block: Block, materialWrapper: Wrapper<MaterialKey, MaterialKey>): MaterialKey

    abstract fun transform(materialKey: MaterialKey, materialWrapper: Wrapper<MaterialKey, MaterialKey>): Block?

}

class BlockTransformerRepository {

    private val transformerByMaterialKey = mutableMapOf<MaterialCategoryKey, BlockTransformer>()
    private lateinit var defaultTransformer: BlockTransformer;
    private lateinit var materialWrapper: Wrapper<MaterialKey, MaterialKey>;

    fun registerDefaultTransformer(transformer: BlockTransformer) {
        defaultTransformer = transformer
    }

    fun registerMaterialWrapper(materialWrapper: Wrapper<MaterialKey, MaterialKey>) {
        this.materialWrapper = materialWrapper
    }

    fun register(materialCategoryKey: MaterialCategoryKey, blockTransformer: BlockTransformer) {
        transformerByMaterialKey[materialCategoryKey] = blockTransformer
    }

    //server side
    fun transform(block: Block): MaterialKey {
        val materialKey = block.getMaterialKey()
        val blockTransformer = transformerByMaterialKey.getOrDefault(materialKey.materialCategoryKey, defaultTransformer)
        return blockTransformer.transform(block, materialWrapper)
    }

    //client side
    fun reverse(materialKey: MaterialKey): Block? {
        val materialCategoryKey = materialWrapper.reverse(MaterialKey.from(materialKey.id))?.materialCategoryKey
        val blockTransformer = transformerByMaterialKey.getOrDefault(materialCategoryKey, defaultTransformer)
        return blockTransformer.transform(materialKey, materialWrapper)
    }


}


