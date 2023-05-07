package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.animation.AnimationType;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.inventory.EquipmentSlot;
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.NamedInventory;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.particle.Particle;
import eu.mshade.enderframe.protocol.MinecraftSession;
import eu.mshade.enderframe.scoreboard.Scoreboard;
import eu.mshade.enderframe.scoreboard.ScoreboardLine;
import eu.mshade.enderframe.scoreboard.ScoreboardAction;
import eu.mshade.enderframe.scoreboard.ScoreboardLineAction;
import eu.mshade.enderframe.scoreboard.team.Team;
import eu.mshade.enderframe.sound.SoundEffect;
import eu.mshade.enderframe.title.Title;
import eu.mshade.enderframe.title.TitleAction;
import eu.mshade.enderframe.world.Difficulty;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.World;
import eu.mshade.enderframe.world.block.Block;
import eu.mshade.enderframe.world.border.WorldBorder;
import eu.mshade.enderframe.world.border.WorldBorderAction;
import eu.mshade.enderframe.world.chunk.Chunk;
import eu.mshade.enderframe.world.chunk.Section;
import io.netty.channel.Channel;
import org.jetbrains.annotations.NotNull;

import java.security.PublicKey;
import java.util.Collection;
import java.util.List;

public class TempMinecraftSession extends MinecraftSession {


    public TempMinecraftSession(Channel channel) {
        super(channel);
    }

    @Override
    public void sendCompression(int threshold) {

    }

    @Override
    public void sendLoginSuccess() {

    }

    @Override
    public void sendJoinGame(World world, boolean reducedDebugInfo) {

    }

    @Override
    public void sendServerDifficulty(Difficulty difficulty) {

    }

    @Override
    public void sendHeaderAndFooter(String header, String footer) {

    }

    @Override
    public void sendHeaderAndFooter(TextComponent header, TextComponent footer) {

    }

    @Override
    public void sendAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed) {

    }

    @Override
    public void sendKeepAlive(int threshold) {

    }

    @Override
    public void sendEncryption(PublicKey publicKey) {

    }

    @Override
    public void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder) {

    }

    @Override
    public void sendMessage(TextComponent textComponent, TextPosition textPosition) {

    }

    @Override
    public void sendMessage(TextComponent textComponent) {

    }

    @Override
    public void sendMessage(String message) {

    }

    @Override
    public void disconnect(String message) {

    }

    @Override
    public void disconnect(TextComponent message) {

    }

    @Override
    public void teleport(Location location) {

    }

    @Override
    public void sendUpdateLocation(Entity entity) {

    }

    @Override
    public void sendUpdateLocation(Entity entity, Location before, Location now) {

    }

    @Override
    public void sendTeleport(Entity entity) {

    }

    @Override
    public void sendTeleport(Entity entity, Location location) {

    }


    @Override
    public void sendMove(Entity entity) {

    }

    @Override
    public void sendMove(Entity entity, Location before, Location now) {

    }

    @Override
    public void sendMoveAndLook(Entity entity) {

    }

    @Override
    public void sendMoveAndLook(Entity entity, Location before, Location now) {

    }

    @Override
    public void sendLook(Entity entity) {

    }

    @Override
    public void sendLook(Entity entity, Location location) {

    }


    @Override
    public void sendHeadLook(Entity entity) {

    }

    @Override
    public void sendHeadLook(Entity entity, Location location) {

    }


    @Override
    public void sendEntity(Entity... entities) {

    }

    @Override
    public void removeEntity(Entity... entities) {

    }

    @Override
    public void sendMetadata(Entity entity, MetadataKey... entityMetadataKeys) {

    }

    @Override
    public void sendChunk(Chunk chunk) {

    }

    @Override
    public void sendSection(Section section) {

    }

    @Override
    public void sendSectionFromChunk(Chunk chunk) {

    }

    @Override
    public void sendUnloadChunk(Chunk chunk) {

    }

    @Override
    public void sendBlockChange(Vector blockPosition, MaterialKey materialData) {

    }

    @Override
    public void sendBlockChange(Vector blockPosition, Block block) {

    }

    @Override
    public void sendUnsafeBlockChange(Vector blockPosition, MaterialKey materialKey) {

    }

    @Override
    public void sendOpenInventory(NamedInventory inventory) {

    }

    @Override
    public void sendCloseInventory(Inventory inventory) {

    }

    @Override
    public void sendItemStacks(Inventory inventory) {

    }

    @Override
    public void sendItemStack(Inventory inventory, int slot, ItemStack itemStack) {

    }

    @Override
    public void sendDisplayScoreboard(Scoreboard scoreboard) {

    }

    @Override
    public void sendScoreboard(Scoreboard scoreboard, ScoreboardAction mode) {

    }

    @Override
    public void sendUpdateScoreboardLine(Scoreboard scoreboard, ScoreboardLine scoreboardLine, ScoreboardLineAction action) {

    }


    @Override
    public void sendTeams(Team team) {

    }

    @Override
    public void sendSoundEffect(SoundEffect soundEffect) {

    }

    @Override
    public void sendTitle(TitleAction titleAction, Title title) {

    }

    @Override
    public void sendWorldBorder(WorldBorderAction worldBorderAction, WorldBorder worldBorder) {

    }

    @Override
    public void sendParticle(Particle particle) {

    }

    @Override
    public void sendInventoryUpdate(Block block, MetadataKey... metadataKeys) {

    }

    @Override
    public void sendMetadata(@NotNull Entity entity, @NotNull Collection<? extends MetadataKey> entityMetadataKeys) {

    }

    @Override
    public void sendSign(@NotNull Vector vector, @NotNull List<? extends TextComponent> textComponents) {

    }

    @Override
    public void sendEquipment(@NotNull Entity entity, @NotNull EquipmentSlot equipmentSlot, ItemStack itemStack) {

    }

    @Override
    public void sendAnimation(@NotNull Player player, @NotNull AnimationType animationType) {

    }
}
