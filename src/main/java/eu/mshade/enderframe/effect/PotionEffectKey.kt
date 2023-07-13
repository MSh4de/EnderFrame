package eu.mshade.enderframe.effect

interface PotionEffectKey {

    val key: String
    val defaultEffect: String
    val id: Int

    companion object {
        @JvmStatic
        fun from(key: String, defaultEffect: String, id: Int): PotionEffectKey {
            return DefaultPotionEffectKey(key, defaultEffect, id)
        }
    }
}

data class DefaultPotionEffectKey(
    override val key: String,
    override val defaultEffect: String,
    override val id: Int
) : PotionEffectKey


