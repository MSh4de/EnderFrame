package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.GameMode;
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryBufferStore;
import eu.mshade.enderframe.inventory.PlayerInventory;
import eu.mshade.enderframe.mojang.GameProfile;
import eu.mshade.enderframe.protocol.MinecraftProtocolVersion;
import eu.mshade.enderframe.protocol.SessionWrapper;
import eu.mshade.enderframe.world.Chunk;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.net.SocketAddress;
import java.util.Collection;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Player extends LivingEntity implements ProjectileSource {


    protected SocketAddress socketAddress;
    protected MinecraftProtocolVersion minecraftProtocolVersion;
    protected int ping;
    protected String displayName;
    protected GameMode gameMode = GameMode.UNKNOWN;
    protected GameProfile gameProfile;
    protected boolean invulnerable;
    protected boolean flying;
    protected boolean allowFlying;
    protected boolean instantBreak;
    protected float flyingSpeed;
    protected float walkSpeed;
    protected PlayerInventory playerInventory = new PlayerInventory();
    protected Inventory openedInventory;
    protected Queue<Chunk> lookAtChunks = new ConcurrentLinkedQueue<>();
    protected InventoryBufferStore inventoryBufferStore = new InventoryBufferStore();

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
        return getGameProfile().getName();
    }

    public SocketAddress getSocketAddress(){
        return this.socketAddress;
    }

    public void setSocketAddress(SocketAddress socketAddress){
        this.socketAddress = socketAddress;
    }

    public void setMinecraftProtocolVersion(MinecraftProtocolVersion minecraftProtocolVersion) {
        this.minecraftProtocolVersion = minecraftProtocolVersion;
    }

    public MinecraftProtocolVersion getProtocolVersion(){
        return this.minecraftProtocolVersion;
    }

    public int getPing(){
        return this.ping;
    }

    public void setPing(int ping){
        this.ping = ping;
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

    public String getDisplayName(){
        return this.displayName;
    }

    public void setDisplayName(String name){
        this.displayName = name;
    }

    public boolean isInvulnerable() {
        return invulnerable;
    }

    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
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

    public Collection<Chunk> getLookAtChunks(){
        return this.lookAtChunks;
    }

    public boolean hasLookAtChunk(Chunk chunk){
        return this.lookAtChunks.contains(chunk);
    }

    public PlayerInventory getPlayerInventory() {
        return playerInventory;
    }

    public Inventory getOpenedInventory() {
        return openedInventory;
    }

    public void setOpenedInventory(Inventory openedInventory) {
        this.openedInventory = openedInventory;
    }

    public InventoryBufferStore getInventoryBufferStore() {
        return inventoryBufferStore;
    }

    public abstract SessionWrapper getSessionWrapper();

}
