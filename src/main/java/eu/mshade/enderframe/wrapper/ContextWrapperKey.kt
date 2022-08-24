package eu.mshade.enderframe.wrapper

interface ContextWrapperKey {

    fun getContext(): String

    companion object {

        fun from(context: String): ContextWrapperKey {
            return DefaultContextWrapperKey(context)
        }

    }

}

class DefaultContextWrapperKey(private val context: String) : ContextWrapperKey {

    override fun getContext(): String {
        return context
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ContextWrapperKey) return false
        return other.getContext() == context;
    }

    override fun hashCode(): Int {
        return context.hashCode()
    }

}
