package eu.mshade.enderframe.protocol.temp

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
import eu.mshade.enderframe.world.effect.WorldEffectKey
import io.netty.channel.Channel
import java.security.PublicKey

class TempMinecraftSession(channel: Channel) : MinecraftSession(channel) {

    override fun sendCompression(threshold: Int) {
        TODO("Not yet implemented")
    }

    override fun sendLoginSuccess() {
        TODO("Not yet implemented")
    }

    override fun sendJoinGame(world: World, reducedDebugInfo: Boolean) {
        TODO("Not yet implemented")
    }

    override fun sendServerDifficulty(difficulty: Difficulty) {
        TODO("Not yet implemented")
    }

    override fun sendHeaderAndFooter(header: String, footer: String) {
        TODO("Not yet implemented")
    }

    override fun sendHeaderAndFooter(header: TextComponent, footer: TextComponent) {
        TODO("Not yet implemented")
    }

    override fun sendAbilities(
        invulnerable: Boolean,
        flying: Boolean,
        allowFlying: Boolean,
        instantBreak: Boolean,
        flyingSpeed: Float,
        walkSpeed: Float
    ) {
        TODO("Not yet implemented")
    }

    override fun sendKeepAlive(threshold: Int) {
        TODO("Not yet implemented")
    }

    override fun sendEncryption(publicKey: PublicKey) {
        TODO("Not yet implemented")
    }

    override fun sendPlayerInfo(playerInfoBuilder: PlayerInfoBuilder) {
        TODO("Not yet implemented")
    }

    override fun sendMessage(textComponent: TextComponent, textPosition: TextPosition) {
        TODO("Not yet implemented")
    }

    override fun sendMessage(textComponent: TextComponent) {
        TODO("Not yet implemented")
    }

    override fun sendMessage(message: String) {
        TODO("Not yet implemented")
    }

    override fun sendTabComplete(vararg matches: TextComponent) {
        TODO("Not yet implemented")
    }

    override fun disconnect(message: String) {
        TODO("Not yet implemented")
    }

    override fun disconnect(message: TextComponent) {
        TODO("Not yet implemented")
    }

    override fun teleport(location: Location) {
        TODO("Not yet implemented")
    }

    override fun sendUpdateLocation(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendUpdateLocation(entity: Entity, before: Location, now: Location) {
        TODO("Not yet implemented")
    }

    override fun sendTeleport(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendTeleport(entity: Entity, location: Location) {
        TODO("Not yet implemented")
    }

    override fun sendMove(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendMove(entity: Entity, before: Location, now: Location) {
        TODO("Not yet implemented")
    }

    override fun sendMoveAndLook(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendMoveAndLook(entity: Entity, before: Location, now: Location) {
        TODO("Not yet implemented")
    }

    override fun sendLook(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendLook(entity: Entity, location: Location) {
        TODO("Not yet implemented")
    }

    override fun sendHeadLook(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendHeadLook(entity: Entity, location: Location) {
        TODO("Not yet implemented")
    }

    override fun sendEntity(vararg entities: Entity) {
        TODO("Not yet implemented")
    }

    override fun removeEntity(vararg entities: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendMetadata(entity: Entity, vararg entityMetadataKeys: MetadataKey) {
        TODO("Not yet implemented")
    }

    override fun sendMetadata(entity: Entity, entityMetadataKeys: Collection<MetadataKey>) {
        TODO("Not yet implemented")
    }

    override fun sendEntityProperties(entity: Entity) {
        TODO("Not yet implemented")
    }

    override fun sendEntityEffect(entity: Entity, vararg potionEffects: PotionEffect) {
        TODO("Not yet implemented")
    }

    override fun sendChunk(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun sendSection(section: Section) {
        TODO("Not yet implemented")
    }

    override fun sendSectionFromChunk(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun sendUnloadChunk(chunk: Chunk) {
        TODO("Not yet implemented")
    }

    override fun sendBlockChange(blockPosition: Vector, materialKey: MaterialKey) {
        TODO("Not yet implemented")
    }

    override fun sendBlockChange(blockPosition: Vector, block: Block) {
        TODO("Not yet implemented")
    }

    override fun sendUnsafeBlockChange(blockPosition: Vector, materialKey: MaterialKey) {
        TODO("Not yet implemented")
    }

    override fun sendSign(vector: Vector, textComponents: List<TextComponent>) {
        TODO("Not yet implemented")
    }

    override fun sendOpenInventory(inventory: NamedInventory) {
        TODO("Not yet implemented")
    }

    override fun sendCloseInventory(inventory: Inventory) {
        TODO("Not yet implemented")
    }

    override fun sendItemStacks(inventory: Inventory) {
        TODO("Not yet implemented")
    }

    override fun sendItemStack(inventory: Inventory, slot: Int, itemStack: ItemStack?) {
        TODO("Not yet implemented")
    }

    override fun sendDisplayScoreboard(scoreboard: Scoreboard) {
        TODO("Not yet implemented")
    }

    override fun sendScoreboard(scoreboard: Scoreboard, mode: ScoreboardAction) {
        TODO("Not yet implemented")
    }

    override fun sendUpdateScoreboardLine(
        scoreboard: Scoreboard,
        scoreboardLine: ScoreboardLine,
        action: ScoreboardLineAction
    ) {
        TODO("Not yet implemented")
    }

    override fun sendTeams(team: Team) {
        TODO("Not yet implemented")
    }

    override fun sendSoundEffect(soundEffect: SoundEffect) {
        TODO("Not yet implemented")
    }

    override fun sendTitle(titleAction: TitleAction, title: Title) {
        TODO("Not yet implemented")
    }

    override fun sendWorldBorder(worldBorderAction: WorldBorderAction, worldBorder: WorldBorder) {
        TODO("Not yet implemented")
    }

    override fun sendParticle(particle: Particle) {
        TODO("Not yet implemented")
    }

    override fun sendInventoryUpdate(block: Block, vararg metadataKeys: MetadataKey) {
        TODO("Not yet implemented")
    }

    override fun sendEquipment(entity: Entity, equipmentSlot: EquipmentSlot, itemStack: ItemStack?) {
        TODO("Not yet implemented")
    }

    override fun sendRemoveEntityEffect(entity: Entity, vararg effectTypes: PotionEffectKey) {
        TODO("Not yet implemented")
    }

    override fun sendAnimation(player: Player, animationType: AnimationType) {
        TODO("Not yet implemented")
    }

    override fun sendWorldEffect(
        worldEffect: WorldEffectKey,
        location: Vector,
        material: MaterialKey,
        relativeVolume: Boolean
    ) {
        TODO("Not yet implemented")
    }
}
