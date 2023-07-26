package eu.mshade.enderframe.protocol

import eu.mshade.enderframe.PlayerInfoBuilder
import eu.mshade.enderframe.animation.AnimationType
import eu.mshade.enderframe.effect.PotionEffect
import eu.mshade.enderframe.effect.PotionEffectKey
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.inventory.Inventory
import eu.mshade.enderframe.inventory.NamedInventory
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.mojang.GameProfile
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.mojang.chat.TextPosition
import eu.mshade.enderframe.particle.Particle
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutDisconnect
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutPluginMessage
import eu.mshade.enderframe.scoreboard.Scoreboard
import eu.mshade.enderframe.scoreboard.ScoreboardAction
import eu.mshade.enderframe.scoreboard.ScoreboardLine
import eu.mshade.enderframe.scoreboard.ScoreboardLineAction
import eu.mshade.enderframe.scoreboard.team.Team
import eu.mshade.enderframe.sound.SoundEffect
import eu.mshade.enderframe.title.Title
import eu.mshade.enderframe.title.TitleAction
import eu.mshade.enderframe.world.Difficulty
import eu.mshade.enderframe.world.Location
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.World
import eu.mshade.enderframe.world.block.Block
import eu.mshade.enderframe.world.border.WorldBorder
import eu.mshade.enderframe.world.border.WorldBorderAction
import eu.mshade.enderframe.world.chunk.Chunk
import eu.mshade.enderframe.world.chunk.Section
import eu.mshade.enderframe.world.effect.WorldEffectKey
import io.netty.channel.Channel
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandler
import java.net.InetSocketAddress
import java.security.PublicKey
import java.util.concurrent.ThreadLocalRandom
import java.util.function.Consumer
import javax.crypto.SecretKey

abstract class MinecraftSession(@JvmField val channel: Channel) {
    val sessionId: String
    val verifyToken = ByteArray(4)

    @JvmField
    var gameProfile: GameProfile? = null
    var handshake: MinecraftHandshake? = null
    var protocolStatus = MinecraftProtocolStatus.HANDSHAKE
        protected set

    init {
        sessionId = ThreadLocalRandom.current().nextLong().toString(16).trim { it <= ' ' }
        ThreadLocalRandom.current().nextBytes(verifyToken)
    }

    val remoteAddress: InetSocketAddress
        get() = channel.remoteAddress() as InetSocketAddress

    fun sendPacket(packet: MinecraftPacketOut) {
        if (isConnected) channel.writeAndFlush(packet)
    }

    fun sendPacketAndClose(packet: MinecraftPacketOut) {
        if (isConnected) channel.writeAndFlush(packet).addListener(ChannelFutureListener.CLOSE)
    }

    fun toggleProtocol(minecraftProtocol: MinecraftProtocol) {
        channel.flush()
        MinecraftProtocolPipeline.get().setProtocol(channel, minecraftProtocol)
    }

    fun toggleProtocolStatus(minecraftProtocolStatus: MinecraftProtocolStatus) {
        protocolStatus = minecraftProtocolStatus
    }

    fun enableEncryption(sharedSecret: SecretKey) {
        updatePipeline("encryption", MinecraftPacketEncryption(sharedSecret))
    }

    fun enableCompression(threshold: Int) {
        updatePipeline("compression", MinecraftPacketCompression(threshold))
    }

    private fun updatePipeline(key: String, handler: ChannelHandler) {
        channel.pipeline().replace(key, key, handler)
    }

    val isConnected: Boolean
        get() = channel.isActive
    val protocol: MinecraftProtocol
        get() = MinecraftProtocolPipeline.get().getProtocol(channel)
    val player: Player
        get() = MinecraftProtocolPipeline.get().getPlayer(channel)

    fun sendDisconnect(textComponent: TextComponent) {
        sendPacketAndClose(MinecraftPacketOutDisconnect(textComponent))
    }

    fun sendDisconnect(s: String) {
        sendDisconnect(TextComponent.of(s))
    }

    abstract fun sendCompression(threshold: Int)
    abstract fun sendLoginSuccess()
    abstract fun sendJoinGame(world: World, reducedDebugInfo: Boolean)
    abstract fun sendServerDifficulty(difficulty: Difficulty)
    abstract fun sendHeaderAndFooter(header: String, footer: String)
    abstract fun sendHeaderAndFooter(header: TextComponent, footer: TextComponent)
    abstract fun sendAbilities(
        invulnerable: Boolean,
        flying: Boolean,
        allowFlying: Boolean,
        instantBreak: Boolean,
        flyingSpeed: Float,
        walkSpeed: Float
    )

    abstract fun sendKeepAlive(threshold: Int)
    abstract fun sendEncryption(publicKey: PublicKey)
    abstract fun sendPlayerInfo(playerInfoBuilder: PlayerInfoBuilder)
    abstract fun sendMessage(textComponent: TextComponent, textPosition: TextPosition)
    fun sendMessage(s: String, textPosition: TextPosition) {
        sendMessage(TextComponent.of(s), textPosition)
    }

    abstract fun sendMessage(textComponent: TextComponent)
    abstract fun sendMessage(message: String)
    abstract fun sendTabComplete(vararg matches: TextComponent)
    abstract fun disconnect(message: String)
    abstract fun disconnect(message: TextComponent)
    abstract fun teleport(location: Location)
    abstract fun sendUpdateLocation(entity: Entity)
    abstract fun sendUpdateLocation(entity: Entity, before: Location, now: Location)
    abstract fun sendTeleport(entity: Entity)
    abstract fun sendTeleport(entity: Entity, location: Location)
    abstract fun sendMove(entity: Entity)
    abstract fun sendMove(entity: Entity, before: Location, now: Location)
    abstract fun sendMoveAndLook(entity: Entity)
    abstract fun sendMoveAndLook(entity: Entity, before: Location, now: Location)
    abstract fun sendLook(entity: Entity)
    abstract fun sendLook(entity: Entity, location: Location)
    abstract fun sendHeadLook(entity: Entity)
    abstract fun sendHeadLook(entity: Entity, location: Location)
    abstract fun sendEntity(vararg entities: Entity)
    abstract fun removeEntity(vararg entities: Entity)
    abstract fun sendMetadata(entity: Entity, vararg entityMetadataKeys: MetadataKey)
    abstract fun sendMetadata(entity: Entity, entityMetadataKeys: Collection<MetadataKey>)
    abstract fun sendEntityProperties(entity: Entity)
//    abstract fun sendEntityProperties(entity: Entity, vararg entityPropertyKeys: EntityPropertyKey)
    abstract fun sendEntityEffect(entity: Entity, vararg potionEffects: PotionEffect)
    abstract fun sendChunk(chunk: Chunk)
    abstract fun sendSection(section: Section)
    abstract fun sendSectionFromChunk(chunk: Chunk)
    abstract fun sendUnloadChunk(chunk: Chunk)
    fun sendPluginMessage(channel: String, payload: Consumer<MinecraftByteBuf>) {
        sendPacket(MinecraftPacketOutPluginMessage(channel, payload))
    }

    abstract fun sendBlockChange(blockPosition: Vector, materialKey: MaterialKey)
    abstract fun sendBlockChange(blockPosition: Vector, block: Block)
    abstract fun sendUnsafeBlockChange(blockPosition: Vector, materialKey: MaterialKey)
    abstract fun sendSign(vector: Vector, textComponents: List<TextComponent>)
    fun sendSign(vector: Vector, vararg textComponents: TextComponent) {
        sendSign(vector, listOf(*textComponents))
    }

    abstract fun sendOpenInventory(inventory: NamedInventory)
    abstract fun sendCloseInventory(inventory: Inventory)
    abstract fun sendItemStacks(inventory: Inventory)
    abstract fun sendItemStack(inventory: Inventory, slot: Int, itemStack: ItemStack?)
    abstract fun sendDisplayScoreboard(scoreboard: Scoreboard)
    abstract fun sendScoreboard(scoreboard: Scoreboard, mode: ScoreboardAction)
    abstract fun sendUpdateScoreboardLine(
        scoreboard: Scoreboard, scoreboardLine: ScoreboardLine, action: ScoreboardLineAction
    )

    abstract fun sendTeams(team: Team)
    abstract fun sendSoundEffect(soundEffect: SoundEffect)
    abstract fun sendTitle(titleAction: TitleAction, title: Title)
    abstract fun sendWorldBorder(worldBorderAction: WorldBorderAction, worldBorder: WorldBorder)
    abstract fun sendParticle(particle: Particle)
    abstract fun sendInventoryUpdate(block: Block, vararg metadataKeys: MetadataKey)
    abstract fun sendEquipment(entity: Entity, equipmentSlot: EquipmentSlot, itemStack: ItemStack?)
    abstract fun sendRemoveEntityEffect(entity: Entity, vararg effectTypes: PotionEffectKey)
    abstract fun sendAnimation(player: Player, animationType: AnimationType)
    abstract fun sendWorldEffect(worldEffect: WorldEffectKey, location: Vector, material: MaterialKey, relativeVolume: Boolean)


}
