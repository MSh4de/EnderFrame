package eu.mshade.enderframe

import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.gamerule.GameRuleRepository
import eu.mshade.enderframe.item.ItemRuleRepository
import eu.mshade.enderframe.protocol.MinecraftProtocolRepository
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.block.BlockBehaviorRepository
import eu.mshade.enderframe.world.block.TickableBlockRepository
import java.util.UUID

interface MinecraftServer {

    fun addPlayer(player: Player)

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

    fun getItemRules(): ItemRuleRepository

    /**
     * get all sound, material, particle loaded
     * recipe management
     * achievement management
     * item rule management
     * game rule management
     * get port, server name, server icon, server version[range]
     * tick management
     */


    fun getTickableBlocks(): TickableBlockRepository
}
