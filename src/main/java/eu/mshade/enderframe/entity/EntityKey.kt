package eu.mshade.enderframe.entity

interface EntityKey {

    fun getName(): String

    companion object {

        fun of(name: String): EntityKey {
            return DefaultEntityKey(name)
        }
    }
}

class DefaultEntityKey(private val name: String): EntityKey {

    override fun getName(): String {
        return name
    }
}