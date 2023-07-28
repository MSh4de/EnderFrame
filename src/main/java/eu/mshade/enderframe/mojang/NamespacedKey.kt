package eu.mshade.enderframe.mojang

import java.util.*

class NamespacedKey
/**
 * Create a key in a specific namespace.
 *
 * @param namespace
 * @param key
 */
internal constructor(
    val namespace: String, val key: String
) {

    override fun hashCode(): Int {
        var hash = 5
        hash = 47 * hash + namespace.hashCode()
        hash = 47 * hash + key.hashCode()
        return hash
    }

    override fun equals(obj: Any?): Boolean {
        if (obj == null) {
            return false
        }
        if (javaClass != obj.javaClass) {
            return false
        }
        val other = obj as NamespacedKey
        return namespace == other.namespace && key == other.key
    }

    override fun toString(): String {
        return "$namespace:$key"
    }

    companion object {
        @JvmField val MINECRAFT = "minecraft"

        @JvmField val MSHADE = "mshade"

        private val FORMAT = Regex("[a-z]+:[a-z]+")

        /**
         * Return a new random key in the [.MSHADE] namespace.
         *
         * @return new key
         */
        internal fun randomKey(): NamespacedKey {
            return NamespacedKey(MSHADE, UUID.randomUUID().toString())
        }

        /**
         * Get a key in the Minecraft namespace.
         *
         * @param key the key to use
         * @return new key in the Minecraft namespace
         */
        @JvmStatic
        fun minecraft(key: String): NamespacedKey {
            return NamespacedKey(MINECRAFT, key)
        }

        @JvmStatic
        fun fromString(string: String): NamespacedKey {
            val keys = string.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            if(!isValidFormat(string))
                throw IllegalArgumentException("Invalid NamespacedKey format: $string (must be in namespace:key format)")
            return NamespacedKey(keys[0], keys[1])
        }

        @JvmStatic
        fun isValidFormat(string: String) = FORMAT.matches(string)
    }
}
