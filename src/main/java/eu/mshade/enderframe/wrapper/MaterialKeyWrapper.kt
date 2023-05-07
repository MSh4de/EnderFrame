package eu.mshade.enderframe.wrapper

import eu.mshade.enderframe.item.MaterialKey

open class MaterialKeyWrapper: ContextualWrapper<MaterialKey, MaterialKey, MaterialWrapperContext>() {

    protected fun register(input: MaterialKey, output: MaterialKey) {
        for (value in MaterialWrapperContext.values()) {
            registerMapping(value, input, output)
            registerReverseMapping(value, input, output)
        }
    }

    protected fun registerMapping(input: MaterialKey, output: MaterialKey) {
        for (value in MaterialWrapperContext.values()) {
            registerMapping(value, input, output)
        }
    }

    protected fun registerReverseMapping(input: MaterialKey, output: MaterialKey) {
        for (value in MaterialWrapperContext.values()) {
            registerReverseMapping(value, input, output)
        }
    }

}