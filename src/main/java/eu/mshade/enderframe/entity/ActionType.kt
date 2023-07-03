package eu.mshade.enderframe.entity

enum class ActionType(val index: Int) {

    START_SNEAKING(0),
    STOP_SNEAKING(1),
    LEAVE_BED(2),
    START_SPRINTING(3),
    STOP_SPRINTING(4),
    JUMP_WITH_HORSE(5),
    OPEN_RIDDEN_HORSE_INVENTORY(6);

    companion object {
        private val actionTypes: MutableMap<Int, ActionType> = HashMap()

        init {
            for (value in values()) {
                actionTypes[value.index] = value
            }
        }

        @JvmStatic
        fun getActionTypeByIndex(index: Int): ActionType? {
            return actionTypes[index]
        }
    }
}
