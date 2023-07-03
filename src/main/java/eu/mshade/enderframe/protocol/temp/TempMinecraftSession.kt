package eu.mshade.enderframe.protocol.temp

import eu.mshade.enderframe.PlayerInfoBuilder
import eu.mshade.enderframe.effect.Effect
import eu.mshade.enderframe.effect.EffectKey
import eu.mshade.enderframe.entity.Entity
import eu.mshade.enderframe.inventory.EquipmentSlot
import eu.mshade.enderframe.inventory.Inventory
import eu.mshade.enderframe.inventory.NamedInventory
import eu.mshade.enderframe.item.ItemStack
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.mojang.chat.TextPosition
import eu.mshade.enderframe.particle.Particle
import eu.mshade.enderframe.protocol.MinecraftSession
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
import io.netty.channel.Channel
import java.security.PublicKey

class TempMinecraftSession(channel: Channel?) : MinecraftSession(channel!!) {
    override fun sendCompression(threshold: Int) {}
    override fun sendLoginSuccess() {}
    override fun sendJoinGame(world: World, reducedDebugInfo: Boolean) {}
    override fun sendServerDifficulty(difficulty: Difficulty) {}
    override fun sendHeaderAndFooter(header: String, footer: String) {}
    override fun sendHeaderAndFooter(header: TextComponent, footer: TextComponent) {}
    override fun sendAbilities(
        invulnerable: Boolean,
        flying: Boolean,
        allowFlying: Boolean,
        instantBreak: Boolean,
        flyingSpeed: Float,
        walkSpeed: Float
    ) {
    }

    override fun sendKeepAlive(threshold: Int) {}
    override fun sendEncryption(publicKey: PublicKey) {}
    override fun sendPlayerInfo(playerInfoBuilder: PlayerInfoBuilder) {}
    override fun sendMessage(textComponent: TextComponent, textPosition: TextPosition) {}
    override fun sendMessage(textComponent: TextComponent) {}
    override fun sendMessage(message: String) {}
    override fun disconnect(message: String) {}
    override fun disconnect(message: TextComponent) {}
    override fun teleport(location: Location) {}
    override fun sendUpdateLocation(entity: Entity) {}
    override fun sendUpdateLocation(entity: Entity, before: Location, now: Location) {}
    override fun sendTeleport(entity: Entity) {}
    override fun sendTeleport(entity: Entity, location: Location) {}
    override fun sendMove(entity: Entity) {}
    override fun sendMove(entity: Entity, before: Location, now: Location) {}
    override fun sendMoveAndLook(entity: Entity) {}
    override fun sendMoveAndLook(entity: Entity, before: Location, now: Location) {}
    override fun sendLook(entity: Entity) {}
    override fun sendLook(entity: Entity, location: Location) {}
    override fun sendHeadLook(entity: Entity) {}
    override fun sendHeadLook(entity: Entity, location: Location) {}
    override fun sendEntity(vararg entities: Entity) {}
    override fun removeEntity(vararg entities: Entity) {}
    override fun sendMetadata(entity: Entity, vararg entityMetadataKeys: MetadataKey) {}
    override fun sendChunk(chunk: Chunk) {}
    override fun sendSection(section: Section) {}
    override fun sendSectionFromChunk(chunk: Chunk) {}
    override fun sendUnloadChunk(chunk: Chunk) {}
    override fun sendBlockChange(blockPosition: Vector, materialData: MaterialKey) {}
    override fun sendBlockChange(blockPosition: Vector, block: Block) {}
    override fun sendUnsafeBlockChange(blockPosition: Vector, materialKey: MaterialKey) {}
    override fun sendOpenInventory(inventory: NamedInventory) {}
    override fun sendCloseInventory(inventory: Inventory) {}
    override fun sendItemStacks(inventory: Inventory) {}
    override fun sendItemStack(inventory: Inventory, slot: Int, itemStack: ItemStack?) {}
    override fun sendDisplayScoreboard(scoreboard: Scoreboard) {}
    override fun sendScoreboard(scoreboard: Scoreboard, mode: ScoreboardAction) {}
    override fun sendUpdateScoreboardLine(
        scoreboard: Scoreboard,
        scoreboardLine: ScoreboardLine,
        action: ScoreboardLineAction
    ) {
    }

    override fun sendTeams(team: Team) {}
    override fun sendSoundEffect(soundEffect: SoundEffect) {}
    override fun sendTitle(titleAction: TitleAction, title: Title) {}
    override fun sendWorldBorder(worldBorderAction: WorldBorderAction, worldBorder: WorldBorder) {}
    override fun sendParticle(particle: Particle) {}
    override fun sendInventoryUpdate(block: Block, vararg metadataKeys: MetadataKey) {}
    override fun sendMetadata(entity: Entity, entityMetadataKeys: Collection<MetadataKey>) {}
    override fun sendSign(vector: Vector, textComponents: List<TextComponent>) {}
    override fun sendEquipment(entity: Entity, equipmentSlot: EquipmentSlot, itemStack: ItemStack?) {}
    override fun sendRemoveEntityEffect(entity: Entity, vararg effectTypes: EffectKey) {
        TODO("Not yet implemented")
    }

    override fun sendEntityProperties(entity: Entity) {}
    override fun sendEntityEffect(entity: Entity, vararg effects: Effect) {
        TODO("Not yet implemented")
    }
}
