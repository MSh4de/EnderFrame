package eu.mshade.enderframe.wrapper

class WrapperRepository {

    private var wrappers = mutableMapOf<ContextWrapperKey, Wrapper<*, *>>()

    fun register(key: ContextWrapperKey, wrapper: Wrapper<*, *>) {
        wrappers[key] = wrapper
    }

    fun get(key: ContextWrapperKey): Wrapper<*, *>? {
        return wrappers[key]
    }

    fun getWrappers(): List<Wrapper<*, *>> {
        return wrappers.values.toList()
    }

}