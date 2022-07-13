package eu.mshade.enderframe.protocol;

import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.item.MaterialData;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.packet.PacketOutDisconnect;
import eu.mshade.enderframe.protocol.packet.PacketOutPluginMessage;
import eu.mshade.enderframe.world.*;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;

import javax.crypto.SecretKey;
import java.security.PublicKey;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public abstract class SessionWrapper {

    private final Channel channel;
    private final String sessionId;
    private final byte[] verifyToken = new byte[4];
    private GameProfile gameProfile;
    private Handshake handshake;
    private ProtocolStatus protocolStatus = ProtocolStatus.HANDSHAKE;

    public SessionWrapper(Channel channel) {
        this.channel = channel;
        this.sessionId = Long.toString(ThreadLocalRandom.current().nextLong(), 16).trim();
        ThreadLocalRandom.current().nextBytes(verifyToken);
    }

    public Channel getChannel() {
        return channel;
    }

    public void sendPacket(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet);
    }

    public void sendPacketAndClose(PacketOut packet) {
        if (isConnected())
            channel.writeAndFlush(packet).addListener(ChannelFutureListener.CLOSE);
    }

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile) {
        this.gameProfile = gameProfile;
    }

    public Handshake getHandshake() {
        return handshake;
    }

    public void setHandshake(Handshake handshake) {
        this.handshake = handshake;
    }

    public ProtocolStatus getProtocolStatus() {
        return protocolStatus;
    }

    public void toggleProtocol(Protocol protocol){
        this.channel.flush();
        ProtocolPipeline.get().setProtocol(this.channel, protocol);
    }

    public void toggleProtocolStatus(ProtocolStatus protocolStatus){
        this.protocolStatus = protocolStatus;
    }

    public void enableEncryption(SecretKey sharedSecret) {
        updatePipeline("encryption", new PacketEncryption(sharedSecret));
    }

    public void enableCompression(int threshold){
        updatePipeline("compression", new PacketCompression(threshold));
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

    public void sendDisconnect(TextComponent textComponent){
        this.sendPacketAndClose(new PacketOutDisconnect(textComponent));
    }

    public void sendDisconnect(String s){
        sendDisconnect(TextComponent.of(s));
    }
    public abstract void sendCompression(int threshold);

   public abstract void sendLoginSuccess();

   public abstract void sendJoinGame(World world, boolean reducedDebugInfo);

   public abstract void sendHeadAndFooter(String header, String footer);

   public abstract void sendHeadAndFooter(TextComponent header, TextComponent footer);

   public abstract void sendAbilities(boolean invulnerable, boolean flying, boolean allowFlying, boolean instantBreak, float flyingSpeed, float walkSpeed);

   public abstract void sendKeepAlive(int threshold);

   public abstract void sendEncryption(PublicKey publicKey);

   public abstract void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

   public abstract void sendMessage(TextComponent textComponent, TextPosition textPosition);

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

   public abstract void sendUnloadChunk(Chunk chunk);

   public void sendPluginMessage(String channel, Consumer<ProtocolBuffer> payload){
       sendPacket(new PacketOutPluginMessage(channel, payload));
   }

   public abstract void sendBlockChange(Vector blockPosition, MaterialKey materialKey);
}