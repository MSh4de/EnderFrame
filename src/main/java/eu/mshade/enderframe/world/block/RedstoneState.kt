package eu.mshade.enderframe.world.block

enum class RedstoneState(val id: Int) {
    NONE(-1),
    EMITTING(0),
    RECEIVING(1),
    REPLICATION(2),
    WIRE(3);

    companion object {
        val stateById = mutableMapOf<Int, RedstoneState>()

        init {
            for (state in values()) {
                stateById[state.id] = state
            }
        }

        fun fromId(id: Int): RedstoneState {
            return stateById[id] ?: throw IllegalArgumentException("Unknown redstone state id: $id")
        }
    }
}
