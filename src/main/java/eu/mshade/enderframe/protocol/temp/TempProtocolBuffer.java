package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.world.Chunk;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Section;
import eu.mshade.enderframe.world.World;
import io.netty.buffer.ByteBuf;

import java.security.PublicKey;

public class TempProtocolBuffer implements ProtocolBuffer {


    @Override
    public void writeItemStack(ByteBuf byteBuf, ItemStack itemStack) {

    }

    @Override
    public ItemStack readItemStack(ByteBuf byteBuf) {
        return null;
    }

    @Override
    public void writeEntityMetadata(ByteBuf byteBuf, Entity entity, EntityMetadataType... entityMetadataType) {

    }

    @Override
    public void sendCompression(Player player, int threshold) {

    }

    @Override
    public void sendLoginSuccess(Player player) {

    }

    @Override
    public void sendJoinGame(Player player, World world, boolean reducedDebugInfo) {

    }

    @Override
    public void sendHeadAndFooter(Player player, String header, String footer) {

    }

    @Override
    public void sendAbilities(Player player) {

    }

    @Override
    public void sendKeepAlive(Player player, int threshold) {

    }

    @Override
    public void sendEncryption(Player player, PublicKey publicKey) {

    }

    @Override
    public void sendPlayerInfo(Player player, PlayerInfoBuilder playerInfoBuilder) {

    }

    @Override
    public void sendMessage(Player player, TextComponent textComponent, TextPosition textPosition) {

    }

    @Override
    public void sendMessage(Player player, TextComponent textComponent) {

    }

    @Override
    public void sendMessage(Player player, String message) {

    }

    @Override
    public void disconnect(EnderFrameSession enderFrameSession, String message) {

    }

    @Override
    public void teleport(Player player, Location location) {

    }

    @Override
    public void sendUpdateLocation(Player player, Entity entity) {

    }

    @Override
    public void sendTeleport(Player player, Entity entity) {

    }

    @Override
    public void sendMove(Player player, Entity entity) {

    }

    @Override
    public void sendMoveAndLook(Player player, Entity entity) {

    }

    @Override
    public void sendLook(Player player, Entity entity) {

    }

    @Override
    public void sendHeadLook(Player player, Entity entity) {

    }

    @Override
    public void sendEntity(Player player, Entity... entities) {

    }

    @Override
    public void removeEntity(Player player, Entity... entities) {

    }

    @Override
    public void sendMetadata(Player player, Entity entity, EntityMetadataType... entityMetadataTypes) {

    }

    @Override
    public void sendChunk(Player player, Chunk chunk) {

    }

    @Override
    public void sendSection(Player player, Section section) {

    }

    @Override
    public void sendUnloadChunk(Player player, Chunk chunk) {

    }
}
