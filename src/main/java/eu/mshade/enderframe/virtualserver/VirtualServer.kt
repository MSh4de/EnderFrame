package eu.mshade.enderframe.virtualserver

import eu.mshade.enderframe.entity.Player
import java.util.UUID

open class VirtualServer(val name: String, val time: Long = System.currentTimeMillis(), val parent: VirtualServer? = null) {

    private val players = mutableListOf<Player>()

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun removePlayer(player: Player) {
        players.remove(player)
    }

    fun getPlayer(name: String): Player? {
        return players.stream().filter { it.name == name }.findFirst().orElse(null)
    }

    fun getPlayer(uniqueId: UUID): Player? {
        return players.stream().filter { it.uniqueId == uniqueId }.findFirst().orElse(null)
    }

    fun getPlayers(): List<Player> {
        return players
    }



}