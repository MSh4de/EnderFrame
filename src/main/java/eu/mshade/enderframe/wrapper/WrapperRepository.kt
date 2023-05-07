package eu.mshade.enderframe.wrapper

class WrapperRepository {

    private var wrappers = mutableMapOf<ContextWrapperKey, Mapper<*, *>>()

    fun register(key: ContextWrapperKey, wrapper: Mapper<*, *>) {
        wrappers[key] = wrapper
    }

    fun get(key: ContextWrapperKey): Mapper<*, *>? {
        return wrappers[key]
    }

    fun getWrappers(): List<Mapper<*, *>> {
        return wrappers.values.toList()
    }

}