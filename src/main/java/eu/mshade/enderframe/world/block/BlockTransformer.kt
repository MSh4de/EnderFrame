package eu.mshade.enderframe.world.block

import eu.mshade.enderframe.item.MaterialKey

abstract class BlockTransformer {

    abstract fun transform(block: Block): MaterialKey

    abstract fun transform(materialKey: MaterialKey): Block

}

