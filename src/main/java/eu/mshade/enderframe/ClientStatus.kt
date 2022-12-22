package eu.mshade.enderframe

enum class ClientStatus(val id: Int) {

    PERFORM_RESPAWN(0),
    REQUEST_STATS(1),
    OPEN_INVENTORY_ACHIEVEMENT(2);

    companion object {

        private val CLIENT_STATUS_BY_ID = mutableMapOf<Int, ClientStatus>()

        init {
            values().forEach { CLIENT_STATUS_BY_ID[it.id] = it }
        }

        fun fromId(id: Int): ClientStatus {
            return CLIENT_STATUS_BY_ID[id] ?: throw IllegalArgumentException("Unknown client status id: $id")
        }

    }

}