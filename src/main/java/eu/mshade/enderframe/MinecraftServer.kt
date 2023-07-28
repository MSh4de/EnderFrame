package eu.mshade.enderframe

import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.event.MinecraftEvent
import eu.mshade.enderframe.gamerule.GameRuleRepository
import eu.mshade.enderframe.item.ItemRuleRepository
import eu.mshade.enderframe.protocol.MinecraftProtocolRepository
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.WorldRepository
import eu.mshade.enderframe.world.block.BlockBehaviorRepository
import eu.mshade.enderframe.world.block.TickableBlockRepository
import eu.mshade.mwork.event.EventBus
import java.util.*
import java.util.concurrent.ConcurrentHashMap

object MinecraftServer {

    private val worldRepository = WorldRepository()
    private val players = ConcurrentHashMap<UUID, Player>()
    private val playerByName = ConcurrentHashMap<String, Player>()
    private val minecraftProtocolRepository = MinecraftProtocolRepository()
    private val blockBehaviorRepository = BlockBehaviorRepository()
    private val gameRuleRepository = GameRuleRepository()
    private val itemRuleRepository = ItemRuleRepository()
    private val tickableBlockRepository = TickableBlockRepository(blockBehaviorRepository)
    private val minecraftEvent = EventBus<MinecraftEvent>()

    fun getWorldRepository(): WorldRepository {
        return worldRepository
    }

    fun getWorlds(): List<World> {
        return worldRepository.getWorlds()
    }

    fun getWorld(worldName: String): World? {
        return worldRepository.getWorld(worldName)
    }

    fun getPlayers(): List<Player> {
        return players.values.toList()
    }

    fun addPlayer(player: Player) {

        if (players.contains(player)) {
            return
        }
        val minecraftSession = player.minecraftSession
        if (minecraftSession.channel == null || !minecraftSession.channel.isActive) {
            return
        }

        val gameProfile = minecraftSession.gameProfile ?: return

        players[gameProfile.id] = player
        playerByName[gameProfile.name] = player
    }

    fun removePlayer(player: Player) {
        val minecraftSession = player.minecraftSession
        val gameProfile = minecraftSession.gameProfile ?: return

        players.remove(gameProfile.id)
        playerByName.remove(gameProfile.name)
    }

    fun getPlayer(playerName: String): Player? {
        return playerByName[playerName]
    }

    fun getPlayer(uniqueId: UUID): Player? {
        return players[uniqueId]
    }

    fun getMinecraftProtocols(): MinecraftProtocolRepository {
        return minecraftProtocolRepository
    }

    fun getBlockBehaviors(): BlockBehaviorRepository {
        return blockBehaviorRepository
    }

    fun getGameRules(): GameRuleRepository {
        return gameRuleRepository
    }

    fun getItemRules(): ItemRuleRepository {
        return itemRuleRepository
    }

    fun getTickableBlocks(): TickableBlockRepository {
        return tickableBlockRepository
    }

    fun getMinecraftEvent(): EventBus<MinecraftEvent> {
        return minecraftEvent
    }

    /*    fun addPlayer(player: Player)

        fun removePlayer(player: Player)

        fun getPlayer(playerName: String): Player?

        fun getPlayer(uniqueId: UUID): Player?

        fun getOnlinePlayers(): Collection<Player>

        fun getWorlds(): Collection<World>

        fun getWorld(worldName: String): World?

        fun getEntity(uniqueId: UUID): Entity?

        fun getEntities(): Collection<Entity>

        fun getMinecraftProtocols(): MinecraftProtocolRepository

        fun getBlockBehaviors(): BlockBehaviorRepository

        fun getGameRules(): GameRuleRepository

        fun getItemRules(): ItemRuleRepository*/

    /**
     * get all sound, material, particle loaded
     * recipe management
     * achievement management
     * item rule management
     * game rule management
     * get port, server name, server icon, server version[range]
     * tick management
     */


//    fun getTickableBlocks(): TickableBlockRepository
}
