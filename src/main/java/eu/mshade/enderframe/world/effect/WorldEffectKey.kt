package eu.mshade.enderframe.world.effect

interface WorldEffectKey {

    fun getName(): String

    companion object {
        @JvmStatic
        fun from(name: String, category: WorldEffectCategory): WorldEffectKey {
            return DefaultWorldEffectKey(name, category)
        }
    }
}

class DefaultWorldEffectKey(private val name: String, private val category: WorldEffectCategory) : WorldEffectKey {

    override fun getName(): String {
        return name
    }
}