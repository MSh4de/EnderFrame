package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.event.*;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.mwork.MLockableQueue;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Entity {

    protected Location beforeLocation;
    protected Location location;
    private Vector velocity;
    private final int entityId;
    private boolean isFire;
    private boolean isSneaking;
    private boolean isSprinting;
    private boolean isEating;
    private boolean isInvisible;
    private short airTicks;
    private String customName;
    private boolean isCustomNameVisible;
    private boolean isSilent;
    protected UUID uuid;
    private final EntityType entityType;
    private final Queue<Player> viewers = new ConcurrentLinkedQueue<>();

    public Entity(Location location, EntityType entityType, int entityId) {
        this(location, new Vector(), entityId, false, false, false, false, false, (short) 300, "", false, false, UUID.randomUUID(), entityType);
    }

    public Entity(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType) {
        this.beforeLocation = location.clone();
        this.location = location;
        this.velocity = velocity;
        this.entityId = entityId;
        this.isFire = isFire;
        this.isSneaking = isSneaking;
        this.isSprinting = isSprinting;
        this.isEating = isEating;
        this.isInvisible = isInvisible;
        this.airTicks = airTicks;
        this.customName = customName;
        this.isCustomNameVisible = isCustomNameVisible;
        this.isSilent = isSilent;
        this.uuid = uuid;
        this.entityType = entityType;
    }

    public Location getBeforeLocation() {
        return this.beforeLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void teleport(Location location) {
        EntityTeleportEvent entityTeleportEvent = new EntityTeleportEvent(this, location);
        EnderFrame.get().getEnderFrameEventBus().publish(entityTeleportEvent);

        if (!entityTeleportEvent.isCancelled()) {
            this.setUnsafeLocation(this.getLocation());
            this.getViewers()
                    .stream()
                    .map(Player::getEnderFrameSessionHandler)
                    .map(EnderFrameSessionHandler::getEnderFrameSession)
                    .forEach(session -> session.sendTeleport(this));

            if (!this.getBeforeLocation().getChunkBuffer().equals(this.getLocation().getChunkBuffer()))
                sendEntityChunkChange();
        }
    }

    public void move(Location location) {
        EntityMoveEvent entityMoveEvent = new EntityMoveEvent(this, location);
        EnderFrame.get().getEnderFrameEventBus().publish(entityMoveEvent);

        if (!entityMoveEvent.isCancelled()) {
            this.setUnsafeLocation(this.getLocation().clone());
            System.out.println(this.getViewers());
            this.getViewers()
                    .stream()
                    .map(Player::getEnderFrameSessionHandler)
                    .map(EnderFrameSessionHandler::getEnderFrameSession)
                    .forEach(session -> session.moveTo(this));

            if (!this.getBeforeLocation().getChunkBuffer().equals(this.getLocation().getChunkBuffer()))
                sendEntityChunkChange();
        }
    }

    private void sendEntityChunkChange() {
        EntityChunkChangeEvent entityChunkChangeEvent = new EntityChunkChangeEvent(this);
        EnderFrame.get().getEnderFrameEventBus().publish(entityChunkChangeEvent);

        if (!entityChunkChangeEvent.isCancelled()) {
            this.getBeforeLocation().getChunkBuffer().removeEntity(this);
            this.getLocation().getChunkBuffer().addEntity(this);
        }
    }

    public void setUnsafeLocation(Location location) {
        this.beforeLocation = this.location;
        this.location = location;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public int getEntityId() {
        return entityId;
    }

    public boolean isFire() {
        return isFire;
    }

    public void setFire(boolean fire) {
        isFire = fire;
    }

    public boolean isSneaking() {
        return isSneaking;
    }

    public void setSneaking(boolean sneaking) {
        isSneaking = sneaking;
    }

    public boolean isSprinting() {
        return isSprinting;
    }

    public void setSprinting(boolean sprinting) {
        isSprinting = sprinting;
    }

    public boolean isEating() {
        return isEating;
    }

    public void setEating(boolean eating) {
        isEating = eating;
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public void setInvisible(boolean invisible) {
        isInvisible = invisible;
    }

    public short getAirTicks() {
        return airTicks;
    }

    public void setAirTicks(short airTicks) {
        this.airTicks = airTicks;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean isCustomNameVisible() {
        return isCustomNameVisible;
    }

    public void setCustomNameVisible(boolean customNameVisible) {
        isCustomNameVisible = customNameVisible;
    }

    public boolean isSilent() {
        return isSilent;
    }

    public void setSilent(boolean silent) {
        isSilent = silent;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public EntityType getType() {
        return entityType;
    }

    public Queue<Player> getViewers() {
        return viewers;
    }

    public void addViewer(Player player) {
        EntitySeeEvent entitySeeEvent = new EntitySeeEvent(this, player);
        EnderFrame.get().getEnderFrameEventBus().publish(entitySeeEvent);
        if (!entitySeeEvent.isCancelled()) {
            EnderFrameSession enderFrameSession = player.getEnderFrameSessionHandler().getEnderFrameSession();
            enderFrameSession.sendEntity(this);
            this.getViewers().add(player);
        }
    }

    public void removeViewer(Player player) {
        EntityUnseeEvent entityUnseeEvent = new EntityUnseeEvent(this, player);
        EnderFrame.get().getEnderFrameEventBus().publish(entityUnseeEvent);
        if (!entityUnseeEvent.isCancelled()) {
            player.getEnderFrameSessionHandler().getEnderFrameSession().removeEntities(this);
            this.getViewers().remove(player);
        }

    }

    public abstract void tick();
}
