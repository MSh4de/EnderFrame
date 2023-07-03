package eu.mshade.enderframe.map

interface MapCursorKey {

    val id: Int
     val key: String

        companion object {
            @JvmStatic
            fun from(id: Int, key: String): MapCursorKey {
                return DefaultMapCursorKey(id, key)
            }
        }
}

data class DefaultMapCursorKey(
    override val id: Int,
    override val key: String
) : MapCursorKey