package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.GameMode;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.metadata.EntityMetadataType;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.SkinPart;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.world.ChunkBuffer;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.SectionBuffer;
import eu.mshade.enderframe.world.Vector;

import java.net.SocketAddress;
import java.security.PublicKey;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Player extends LivingEntity implements ProjectileSource {


    protected String name;
    protected SocketAddress socketAddress;
    protected ProtocolVersion protocolVersion;
    protected int ping;
    protected SkinPart skinPart;
    protected float absorptionHearts;
    protected int score;
    protected Optional<String> playerListName;
    protected GameMode gameMode;
    protected GameProfile gameProfile;
    protected boolean flying;
    protected boolean allowFlying;
    protected boolean instantBreak;
    protected float flyingSpeed;
    protected float walkSpeed;
    protected Queue<ChunkBuffer> lookAtChunks = new ConcurrentLinkedQueue<>();

    public Player(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public Player(Location location, int entityId, EntityType entityType) {
        super(location, entityId, entityType);
    }

    public Player(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.PLAYER);
    }

    public Player(Location location, int entityId) {
        super(location, entityId, EntityType.PLAYER);
    }


    public String getName(){
        return this.name;
    }

    public SocketAddress getSocketAddress(){
        return this.socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress){
        this.socketAddress = socketAddress;
    }

    public ProtocolVersion getProtocolVersion(){
        return this.protocolVersion;
    }

    public int getPing(){
        return this.ping;
    }

    public void setPing(int ping){
        this.ping = ping;
    }

    public SkinPart getSkinParts(){
        return this.skinPart;
    }

    public float getAbsorptionHearts(){
        return this.absorptionHearts;
    }

    public int getScore(){
        return this.score;
    }

    public GameMode getGameMode(){
        return this.gameMode;
    }

    public void setGameMode(GameMode gameMode){
        this.gameMode = gameMode;
    }

    public GameProfile getGameProfile(){
        return this.gameProfile;
    }

    public void setGameProfile(GameProfile gameProfile){
        this.gameProfile = gameProfile;
    }

    public Optional<String> getPlayerListName(){
        return this.playerListName;
    }

    public void setPlayerListName(String name){
        this.name = name;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean isAllowFlying() {
        return allowFlying;
    }

    public void setAllowFlying(boolean allowFlying) {
        this.allowFlying = allowFlying;
    }

    public boolean isInstantBreak() {
        return instantBreak;
    }

    public void setInstantBreak(boolean instantBreak) {
        this.instantBreak = instantBreak;
    }

    public float getFlyingSpeed() {
        return flyingSpeed;
    }

    public void setFlyingSpeed(float flyingSpeed) {
        this.flyingSpeed = flyingSpeed;
    }

    public float getWalkSpeed() {
        return walkSpeed;
    }

    public void setWalkSpeed(float walkSpeed) {
        this.walkSpeed = walkSpeed;
    }

    public abstract void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

    public abstract void sendMessage(TextComponent textComponent, TextPosition textPosition);

    public abstract void sendMessage(TextComponent textComponent);

    public abstract void sendMessage(String message);

    public abstract void disconnect(String message);

    public abstract void teleport(Location location);

    public abstract void sendUpdateLocation(Entity entity);

    public abstract void sendTeleport(Entity entity);

    public abstract void sendMove(Entity entity);

    public abstract void sendMoveAndLook(Entity entity);

    public abstract void sendLook(Entity entity);

    public abstract void sendHeadLook(Entity entity);

    public abstract void sendEntity(Entity... entities);

    public abstract void removeEntity(Entity... entities);

    public abstract void sendMetadata(Entity entity, EntityMetadataType... entityMetadataTypes);

    public abstract void sendChunk(ChunkBuffer chunkBuffer);

    public abstract void sendSection(SectionBuffer sectionBuffer);

    public abstract void sendUnloadChunk(ChunkBuffer chunkBuffer);

    public Collection<ChunkBuffer> getLookAtChunks(){
        return this.lookAtChunks;
    }

    public boolean hasLookAtChunk(ChunkBuffer chunkBuffer){
        return this.lookAtChunks.contains(chunkBuffer);
    }

    public abstract void sendHeadAndFooter(String header, String footer);

    public abstract void updateAbilities();

    public abstract void sendKeepAlive(int threshold);

    public abstract void sendEncryption(PublicKey publicKey);

    public abstract void sendPacket(PacketOut packetOut);
}
