package eu.mshade.enderframe;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.packetevent.PacketMoveType;
import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.packet.PacketOutPlayerAbilities;
import eu.mshade.enderframe.protocol.packet.PacketOutPlayerList;
import eu.mshade.enderframe.world.*;

import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public interface EnderFrameSession {

    Player getPlayer();

    void setPlayer(Player player);

    int getEntityId();

    GameProfile getGameProfile();

    void setGameProfile(GameProfile gameProfile);

    SocketAddress getSocketAddress();

    void setSocketAddress(SocketAddress socketAddress);

    String getSessionId();

    byte[] getVerifyToken();

    Queue<ChunkBuffer> getChunkBuffers();

    void sendKeepAlive(int threshold);

    void sendEncryption(PublicKey publicKey);

    void sendCompression(int threshold);

    void sendLoginSuccess();

    void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

    void sendJoinGame(GameMode gameMode, Dimension dimension, Difficulty difficulty, int maxPlayers, LevelType levelType, boolean reducedDebugInfo);

    default void sendAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed) {
        getPlayer().getEnderFrameSessionHandler().sendPacket(new PacketOutPlayerAbilities(invulnerable, flying, allowFlying, instantBreak, flyingSpeed, walkSpeed));
    }

    void sendPosition(double x, double y, double z);

    void sendPosition(double x, double y, double z, float yaw, float pitch);

    default void sendPosition(Location location) {
        sendPosition(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    default void sendPosition(Position position) {
        sendPosition(position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getYaw());
    }

    void sendMessage(TextComponent textComponent, TextPosition position);

    default void sendMessage(String message) {
        sendMessage(TextComponent.of(message), TextPosition.CHAT);
    }

    void sendDisconnect(String message);

    void sendChunk(ChunkBuffer chunkBuffer);

    void sendUnloadChunk(ChunkBuffer chunkBuffer);

    default void sendPlayerList(String header, String footer) {
        getPlayer().getEnderFrameSessionHandler().sendPacket(new PacketOutPlayerList(header, footer));
    }

    default void sendSquareChunk(int radius, int chunkX, int chunkZ, WorldBuffer worldBuffer) {
        Queue<ChunkBuffer> result = new ConcurrentLinkedQueue<>();
        Queue<ChunkBuffer> chunksLoad = new ConcurrentLinkedQueue<>();
        int rSquared = radius * radius;

        for (int x = chunkX - radius; x <= chunkX + radius; x++) {
            for (int z = chunkZ - radius; z <= chunkZ + radius; z++) {
                if ((chunkX - x) * (chunkX - x) + (chunkZ - z) * (chunkZ - z) <= rSquared) {
                    ChunkBuffer chunkBuffer = worldBuffer.getChunkBuffer(x, z);
                    result.add(chunkBuffer);
                    if (!getChunkBuffers().contains(chunkBuffer)) {
                        chunksLoad.add(chunkBuffer);
                    }

                }
            }
        }
        Queue<ChunkBuffer> overFlowChunk = new ConcurrentLinkedQueue<>();
        for (ChunkBuffer chunkBuffer : getChunkBuffers()) {
            if (!result.contains(chunkBuffer)) {
                sendUnloadChunk(chunkBuffer);
                overFlowChunk.add(chunkBuffer);
            }
        }

        chunksLoad.forEach(this::sendChunk);
        Player player = getPlayer();
        Set<Entity> entities = new HashSet<>();

        for (int x = chunkX - 5; x <= chunkX + 5; x++) {
            for (int z = chunkZ - 5; z <= chunkZ + 5; z++) {
                if ((chunkX - x) * (chunkX - x) + (chunkZ - z) * (chunkZ - z) <= 5*5) {
                    ChunkBuffer chunkBuffer = worldBuffer.getChunkBuffer(x, z);
                    entities.addAll(chunkBuffer.getEntities());
                    chunkBuffer.getViewers().stream().filter(target -> !target.equals(player)).forEach(entities::add);
                }
            }
        }

        Set<Entity> collect = entities.stream().filter(entity -> entity.getLocation().distanceXZ(player.getLocation()) <= 80).collect(Collectors.toSet());

        for (Entity entity : collect) {
            System.out.println(entity);
            System.out.println(entity.getViewers().contains(player));
            if (!entity.getViewers().contains(player)) {
                if (entity instanceof Player){
                    player.addViewer((Player) entity);
                }
                entity.addViewer(player);
            }
        }

        /*
        entities.stream().filter(entity -> !collect.contains(entity)).forEach(entity -> {
            entity.removeViewer(player);
            if (entity instanceof Player) player.removeViewer((Player) entity);
        });

         */

    }


    void sendMetadata(Entity entity, MetadataMeaning... metadataMeanings);

    void removeEntities(Entity... entity);

    <T extends Entity> void sendEntity(T entity);

    void sendTeleport(Entity entity);

    void sendMove(Entity entity);

    void sendMoveAndLook(Entity entity);

    void sendLook(Entity entity);

    void sendHeadLook(Entity entity);

    void moveTo(Entity entity);

}
