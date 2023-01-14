package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.entity.Entity;
<<<<<<< HEAD:src/main/java/eu/mshade/enderframe/protocol/MinecraftSession.java
import eu.mshade.enderframe.entity.Player;
=======
import eu.mshade.enderframe.entity.metadata.EntityMetadataKey;
>>>>>>> entities:src/main/java/eu/mshade/enderframe/protocol/SessionWrapper.java
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.NamedInventory;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.particle.Particle;
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutDisconnect;
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutPluginMessage;
import eu.mshade.enderframe.scoreboard.Scoreboard;
import eu.mshade.enderframe.scoreboard.ScoreboardMode;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjective;
import eu.mshade.enderframe.scoreboard.objective.ScoreboardObjectiveAction;
import eu.mshade.enderframe.scoreboard.team.Team;
import eu.mshade.enderframe.sound.SoundEffect;
import eu.mshade.enderframe.title.Title;
import eu.mshade.enderframe.title.TitleAction;
import eu.mshade.enderframe.world.*;
import eu.mshade.enderframe.world.block.Block;
import eu.mshade.enderframe.world.border.WorldBorder;
import eu.mshade.enderframe.world.border.WorldBorderAction;
import eu.mshade.enderframe.world.chunk.Chunk;
import eu.mshade.enderframe.world.chunk.Section;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;

import javax.crypto.SecretKey;
import java.net.InetSocketAddress;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class MinecraftSession {

    protected final Channel channel;
    protected final String sessionId;
    protected final byte[] verifyToken = new byte[4];
    protected GameProfile gameProfile;
    protected MinecraftHandshake minecraftHandshake;
    protected MinecraftProtocolStatus minecraftProtocolStatus = MinecraftProtocolStatus.HANDSHAKE;

    public MinecraftSession(Channel channel) {
        this.channel = channel;
        this.sessionId = Long.toString(ThreadLocalRandom.current().nextLong(), 16).trim();
        ThreadLocalRandom.current().nextBytes(verifyToken);
    }

    public Channel getChannel() {
        return channel;
    }

    public InetSocketAddress getRemoteAddress() {
        return (InetSocketAddress) channel.remoteAddress();
    }

    public void sendPacket(MinecraftPacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet);
    }

    public void sendPacketAndClose(MinecraftPacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet).addListener(ChannelFutureListener.CLOSE);
    }

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }

    public MinecraftHandshake getHandshake() {
        return minecraftHandshake;
    }

    public void setHandshake(MinecraftHandshake minecraftHandshake) {
        this.minecraftHandshake = minecraftHandshake;
    }

    public MinecraftProtocolStatus getProtocolStatus() {
        return minecraftProtocolStatus;
    }

    public void toggleProtocol(MinecraftProtocol minecraftProtocol) {
        this.channel.flush();
        MinecraftProtocolPipeline.get().setProtocol(this.channel, minecraftProtocol);
    }

    public void toggleProtocolStatus(MinecraftProtocolStatus minecraftProtocolStatus) {
        this.minecraftProtocolStatus = minecraftProtocolStatus;
    }

    public void enableEncryption(SecretKey sharedSecret) {
        updatePipeline("encryption", new MinecraftPacketEncryption(sharedSecret));
    }

    public void enableCompression(int threshold) {
        updatePipeline("compression", new MinecraftPacketCompression(threshold));
    }

    private void updatePipeline(String key, ChannelHandler handler) {
        this.channel.pipeline().replace(key, key, handler);
    }

    public String getSessionId() {
        return sessionId;
    }

    public byte[] getVerifyToken() {
        return verifyToken;
    }

    public boolean isConnected() {
        return channel.isActive();
    }

    public MinecraftProtocol getProtocol() {
        return MinecraftProtocolPipeline.get().getProtocol(this.channel);
    }

    public Player getPlayer() {
        return MinecraftProtocolPipeline.get().getPlayer(this.channel);
    }

    public void sendDisconnect(TextComponent textComponent) {
        this.sendPacketAndClose(new MinecraftPacketOutDisconnect(textComponent));
    }

    public void sendDisconnect(String s) {
        sendDisconnect(TextComponent.of(s));
    }

    public abstract void sendCompression(int threshold);

    public abstract void sendLoginSuccess();

    public abstract void sendJoinGame(World world, boolean reducedDebugInfo);

    public abstract void sendHeaderAndFooter(String header, String footer);

    public abstract void sendHeaderAndFooter(TextComponent header, TextComponent footer);

    public abstract void sendAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed);

    public abstract void sendKeepAlive(int threshold);

    public abstract void sendEncryption(PublicKey publicKey);

    public abstract void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

    public abstract void sendMessage(TextComponent textComponent, TextPosition textPosition);

    public void sendMessage(String s, TextPosition textPosition){
        sendMessage(TextComponent.of(s), textPosition);
    }

    public abstract void sendMessage(TextComponent textComponent);

    public abstract void sendMessage(String message);

    public abstract void disconnect(String message);

    public abstract void disconnect(TextComponent message);

    public abstract void teleport(Location location);

    public abstract void sendUpdateLocation(Entity entity);

    public abstract void sendUpdateLocation(Entity entity, Location before, Location now);

    public abstract void sendTeleport(Entity entity);

    public abstract void sendTeleport(Entity entity, Location location);

    public abstract void sendMove(Entity entity);

    public abstract void sendMove(Entity entity, Location before, Location now);

    public abstract void sendMoveAndLook(Entity entity);

    public abstract void sendMoveAndLook(Entity entity, Location before, Location now);

    public abstract void sendLook(Entity entity);

    public abstract void sendLook(Entity entity, Location location);

    public abstract void sendHeadLook(Entity entity);

    public abstract void sendHeadLook(Entity entity, Location location);

    public abstract void sendEntity(Entity... entities);

    public abstract void removeEntity(Entity... entities);

    public abstract void sendMetadata(Entity entity, EntityMetadataKey... entityMetadataKeys);

    public abstract void sendChunk(Chunk chunk);

    public abstract void sendSection(Section section);

    public abstract void sendSectionFromChunk(Chunk chunk);

    public abstract void sendUnloadChunk(Chunk chunk);

    public void sendPluginMessage(String channel, Consumer<MinecraftByteBuf> payload) {
        sendPacket(new MinecraftPacketOutPluginMessage(channel, payload));
    }

    public abstract void sendBlockChange(Vector blockPosition, MaterialKey materialKey);

    public abstract void sendBlockChange(Vector blockPosition, Block block);

    public abstract void sendUnsafeBlockChange(Vector blockPosition, MaterialKey materialKey);

    public abstract void sendSign(Vector vector, List<TextComponent> textComponents);

    public void sendSign(Vector vector, TextComponent... textComponents){
        sendSign(vector, Arrays.asList(textComponents));
    }

    public abstract void sendOpenInventory(NamedInventory inventory);

    public abstract void sendCloseInventory(Inventory inventory);

    public abstract void sendItemStacks(Inventory inventory);

    public abstract void sendItemStack(Inventory inventory, int slot, ItemStack itemStack);

    public abstract void sendDisplayScoreboard(Scoreboard<?> scoreboard);

    public abstract void sendScoreboardObjective(Scoreboard<?> scoreboard, ScoreboardMode scoreboardMode);

    public abstract void sendUpdateScoreboard(ScoreboardObjective<?> scoreboardObjective, ScoreboardObjectiveAction scoreboardObjectiveAction);

    public abstract void sendTeams(Team team);

    public abstract void sendSoundEffect(SoundEffect soundEffect);

    public abstract void sendTitle(TitleAction titleAction, Title title);

    public abstract void sendWorldBorder(WorldBorderAction worldBorderAction, WorldBorder worldBorder);

    public abstract void sendParticle(Particle particle);

    @Override
    public String toString() {
        return "SessionWrapper{" +
                "channel=" + channel +
                ", sessionId='" + sessionId + '\'' +
                ", verifyToken=" + Arrays.toString(verifyToken) +
                ", gameProfile=" + gameProfile +
                ", handshake=" + minecraftHandshake +
                ", protocolStatus=" + minecraftProtocolStatus +
                '}';
    }
}
