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
import java.security.PublicKey;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface EnderFrameSession {

    Player getPlayer();

    void setPlayer(Player player);

    int getEntityId();

    GameProfile getGameProfile();

    void setGameProfile(GameProfile gameProfile);

    SocketAddress getSocketAddress();

    Location getLocation();

    void setLocation(Location location);

    void setSocketAddress(SocketAddress socketAddress);

    String getSessionId();

    byte[] getVerifyToken();

    Collection<ChunkBuffer> getChunkBuffers();

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
        HashSet<Player> viewers = new HashSet<>();
        Player player = getPlayer();

        for (int x = chunkX - 5; x < chunkX + 5; x++) {
            for (int z = chunkZ - 5; z < chunkZ + 5; z++) {
                    ChunkBuffer chunkBuffer = worldBuffer.getChunkBuffer(x, z);
                    chunkBuffer.getViewers()
                            .stream()
                            .filter(target -> !target.equals(this.getPlayer()) && target.getLocation().distanceOffset(player.getLocation()) < 64)
                            .forEach(viewers::add);
            }
        }

        chunksLoad.forEach(chunkBuffer -> chunkBuffer.getEntities().stream().filter(target -> !target.getViewers().contains(player)).forEach(entity -> entity.addViewer(player)));
        overFlowChunk.forEach(chunkBuffer -> chunkBuffer.getEntities().forEach(entity -> entity.removeViewer(player)));

        player.getViewers().forEach(viewer -> {
            if (!viewers.contains(viewer)) {
                player.removeViewer(viewer);
                viewer.removeViewer(player);
            }
        });

        viewers.forEach(viewer -> {
            if (!viewer.getViewers().contains(player)) viewer.addViewer(player);
            if (!player.getViewers().contains(viewer)) player.addViewer(viewer);
        });
    }

    void sendMetadata(Entity entity, MetadataMeaning... metadataMeanings);

    void removeEntities(Entity... entity);

    <T extends Entity> void sendEntity(T entity);

    void sendTeleport(Entity entity, boolean onGround);

    void sendMove(Entity entity, boolean onGround);

    void sendMoveAndLook(Entity entity, boolean onGround);

    void sendLook(Entity entity, boolean onGround);

    void sendHeadLook(Entity entity);

    void moveTo(Entity entity, PacketMoveType packetMoveType, boolean ground);

}
