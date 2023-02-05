package eu.mshade.enderframe.world.block

enum class SlabType {

    BOTTOM,
    TOP,
    DOUBLE;

    companion object {
        fun fromId(id: Int): SlabType {
            return values()[id]
        }
    }

}