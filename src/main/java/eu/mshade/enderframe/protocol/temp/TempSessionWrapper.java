package eu.mshade.enderframe.protocol.temp;

import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.item.MaterialData;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.SessionWrapper;
import eu.mshade.enderframe.world.*;
import eu.mshade.enderframe.world.border.WorldBorder;
import eu.mshade.enderframe.world.border.WorldBorderAction;
import io.netty.channel.Channel;

import java.security.PublicKey;

public class TempSessionWrapper extends SessionWrapper {


    public TempSessionWrapper(Channel channel) {
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
    public void sendHeadAndFooter(String header, String footer) {

    }

    @Override
    public void sendHeadAndFooter(TextComponent header, TextComponent footer) {

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
    public void sendMetadata(Entity entity, EntityMetadataKey... entityMetadataKeys) {

    }

    @Override
    public void sendChunk(Chunk chunk) {

    }

    @Override
    public void sendSection(Section section) {

    }

    @Override
    public void sendUnloadChunk(Chunk chunk) {

    }

    @Override
    public void sendBlockChange(Vector blockPosition, MaterialKey materialData) {

    }

    @Override
    public void sendOpenInventory(Inventory inventory) {

    }

    @Override
    public void sendItemStacks(Inventory inventory) {

    }

    @Override
    public void sendWorldBorder(WorldBorderAction worldBorderAction, WorldBorder worldBorder) {

    }
}
