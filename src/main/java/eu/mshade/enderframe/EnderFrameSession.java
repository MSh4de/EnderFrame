package eu.mshade.enderframe;

import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.protocol.packet.PacketOutPlayerAbilities;
import eu.mshade.enderframe.protocol.packet.PacketOutPlayerList;
import eu.mshade.enderframe.world.*;
import eu.mshade.mwork.MOptional;

import java.net.SocketAddress;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface EnderFrameSession {

    MOptional<String> getDisplayName();

    void setDisplayName(MOptional<String> displayName);

    void setGameMode(GameMode gameMode);

    GameMode getGameMode();

    GameProfile getGameProfile();

    void setGameProfile(GameProfile gameProfile);

    SocketAddress getSocketAddress();

    EnderFrameSessionHandler getEnderFrameSessionHandler();

    ProtocolVersion getProtocolVersion();

    void setProtocolVersion(ProtocolVersion protocolVersion);

    String getSessionId();

    byte[] getVerifyToken();

    int getPing();

    void setPing(int ping);

    void setLocation(Location location);

    Location getLocation();

    Collection<ChunkBuffer> getChunkBuffers();

    void sendKeepAlive(int threshold);

    void sendEncryption(PublicKey publicKey);

    void sendCompression(int threshold);

    void sendLoginSuccess();

    void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

    void sendJoinGame(GameMode gameMode, Dimension dimension, Difficulty difficulty, int maxPlayers, LevelType levelType, boolean reducedDebugInfo);

    default void sendAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed) {
        getEnderFrameSessionHandler().sendPacket(new PacketOutPlayerAbilities(invulnerable, flying, allowFlying, instantBreak, flyingSpeed, walkSpeed));
    }

    void sendPosition(double x, double y, double z);

    void sendPosition(double x, double y, double z, float yaw, float pitch);

    default void sendPosition(Location location){
        sendPosition(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

    default void sendPosition(Position position){
        sendPosition(position.getX(), position.getY(), position.getZ(), position.getYaw(), position.getYaw());
    };

    void sendMessage(TextComponent textComponent, TextPosition position);

    default void sendMessage(String message) {
        sendMessage(TextComponent.of(message), TextPosition.CHAT);
    };

    void sendDisconnect(String message);

    void sendChunk(ChunkBuffer chunkBuffer);

    void sendUnloadChunk(ChunkBuffer chunkBuffer);

    default void sendPlayerList(String header, String footer){
        getEnderFrameSessionHandler().sendPacket(new PacketOutPlayerList(header, footer));
    }

    default void sendSquareChunk(int radius, int chunkX, int chunkZ, WorldBuffer worldBuffer){
        Queue<ChunkBuffer> result = new ConcurrentLinkedQueue<>();
        Collection<ChunkBuffer> chunksLoad = new ArrayList<>();

        for (int r = 0; r <= radius; r++) {
            for (int x = chunkX - r; x <= chunkX + r; x++) {
                for (int z = chunkZ - r; z <= chunkZ + r; z++) {
                    double dist = (chunkX - x) * (chunkX - x) + (chunkZ - z) * (chunkZ - z);
                    if (dist < r * r && !(dist < (r - 1) * (r - 1))) {
                        ChunkBuffer chunkBuffer = worldBuffer.getChunkBuffer(x, z);
                        result.add(chunkBuffer);
                        if (!getChunkBuffers().contains(chunkBuffer)) {
                            chunksLoad.add(chunkBuffer);
                        }
                    }
                }
            }
        }

        /*
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

         */

        Collection<ChunkBuffer> overFlowChunk = getChunkBuffers();
        for (ChunkBuffer chunkBuffer : overFlowChunk) {
            if (!result.contains(chunkBuffer)) sendUnloadChunk(chunkBuffer);
        }
        chunksLoad.forEach(this::sendChunk);
    }

}
