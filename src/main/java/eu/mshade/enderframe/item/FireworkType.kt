package eu.mshade.enderframe.item

enum class FireworkType(val id: Int) {
    SMALL_BALL(0),
    LARGE_BALL(1),
    STAR(2),
    CREEPER(3),
    BURST(4);

    companion object {
        fun getFireworkType(id: Int): FireworkType {
            return when (id) {
                0 -> SMALL_BALL
                1 -> LARGE_BALL
                2 -> STAR
                3 -> CREEPER
                4 -> BURST
                else -> throw IllegalArgumentException("FireworkType with id $id does not exist")
            }
        }
    }
}