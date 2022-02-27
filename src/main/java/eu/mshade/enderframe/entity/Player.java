package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.GameMode;
import eu.mshade.enderframe.PlayerInfoBuilder;
import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.mojang.SkinParts;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.mojang.chat.TextPosition;
import eu.mshade.enderframe.protocol.ProtocolVersion;
import eu.mshade.enderframe.world.ChunkBuffer;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.SectionBuffer;
import eu.mshade.enderframe.world.Vector;

import java.net.SocketAddress;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Player extends LivingEntity implements ProjectileSource {


    protected String name;
    protected SocketAddress socketAddress;
    protected ProtocolVersion protocolVersion;
    protected int ping;
    protected SkinParts skinParts;
    protected float absorptionHearts;
    protected int score;
    protected Optional<String> playerListName;
    protected GameMode gameMode;
    protected GameProfile gameProfile;
    protected boolean flying;
    protected boolean allowFlying;
    protected boolean instantBreak;
    protected Queue<ChunkBuffer> lookAtChunk = new ConcurrentLinkedQueue<>();

    public Player(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, String name, SocketAddress socketAddress, ProtocolVersion protocolVersion, int ping, SkinParts skinParts, float absorptionHearts, int score, Optional<String> playerListName, GameMode gameMode, GameProfile gameProfile) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.name = name;
        this.socketAddress = socketAddress;
        this.protocolVersion = protocolVersion;
        this.ping = ping;
        this.skinParts = skinParts;
        this.absorptionHearts = absorptionHearts;
        this.score = score;
        this.playerListName = playerListName;
        this.gameMode = gameMode;
        this.gameProfile = gameProfile;
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

    public SkinParts getSkinParts(){
        return this.skinParts;
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

    public abstract void sendPlayerInfo(PlayerInfoBuilder playerInfoBuilder);

    public abstract void sendMessage(TextComponent textComponent, TextPosition textPosition);

    public abstract void sendMessage(TextComponent textComponent);

    public abstract void sendMessage(String message);

    public abstract void disconnect(String message);

    public abstract void sendUpdateLocation(Entity entity);

    public abstract void sendTeleport(Entity entity);

    public abstract void sendMove(Entity entity);

    public abstract void sendMoveAndLook(Entity entity);

    public abstract void sendLook(Entity entity);

    public abstract void sendHeadLook(Entity entity);

    public abstract void sendEntity(Entity... entities);

    public abstract void removeEntity(Entity... entities);

    public abstract void sendMetadata(Entity entity, MetadataMeaning... metadataMeanings);

    public abstract void sendChunk(ChunkBuffer chunkBuffer);

    public abstract void sendSection(SectionBuffer sectionBuffer);

    public abstract void sendUnloadChunk(ChunkBuffer chunkBuffer);

    public abstract void sendHeadAndFooter(String header, String footer);
}
