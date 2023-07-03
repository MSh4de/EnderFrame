package eu.mshade.enderframe.world.block

enum class DiggingStatus(val id: Int) {

    STARTED(0),
    CANCELLED(1),
    FINISHED(2),
    DROP_ITEM_STACK(3),
    DROP_ITEM(4),
    SHOOT_ARROW_OR_FINISH_EATING(5);

    companion object {
        private val DIGGING_STATUS_BY_ID: MutableMap<Int, DiggingStatus> = HashMap()

        init {
            for (diggingStatus in values()) {
                DIGGING_STATUS_BY_ID[diggingStatus.id] = diggingStatus
            }
        }

        fun fromId(id: Int): DiggingStatus? {
            return DIGGING_STATUS_BY_ID[id]
        }
    }
}
