package eu.mshade.enderframe.effect

interface EffectKey {

    val key: String
    val defaultEffect: String
    val id: Int

    companion object {
        @JvmStatic
        fun from(key: String, defaultEffect: String, id: Int): EffectKey {
            return DefaultEffectKey(key, defaultEffect, id)
        }
    }
}

data class DefaultEffectKey(
    override val key: String,
    override val defaultEffect: String,
    override val id: Int
) : EffectKey


