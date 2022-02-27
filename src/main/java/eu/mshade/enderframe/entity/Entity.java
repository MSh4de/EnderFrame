package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.event.*;
import eu.mshade.enderframe.metadata.MetadataMeaning;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Entity {

    protected Location beforeLocation;
    protected Location location;
    protected Vector velocity;
    protected int entityId;
    protected boolean fire;
    protected boolean sneaking;
    protected boolean sprinting;
    protected boolean eating;
    protected boolean invisible;
    protected short airTicks;
    protected String customName;
    protected boolean customNameVisible;
    protected boolean silent;
    protected boolean invulnerable;
    protected UUID uuid;
    protected EntityType entityType;
    protected Queue<Entity> lookAtEntity = new ConcurrentLinkedQueue<>();
    protected Queue<Entity> watchedEntity = new ConcurrentLinkedQueue<>();
    protected Set<MetadataMeaning> metadataMeanings = new HashSet<>();

    public Entity(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType) {
        this.beforeLocation = beforeLocation;
        this.location = location;
        this.velocity = velocity;
        this.entityId = entityId;
        this.fire = fire;
        this.sneaking = sneaking;
        this.sprinting = sprinting;
        this.eating = eating;
        this.invisible = invisible;
        this.airTicks = airTicks;
        this.customName = customName;
        this.customNameVisible = customNameVisible;
        this.silent = silent;
        this.invulnerable = invulnerable;
        this.uuid = uuid;
        this.entityType = entityType;
    }

    public Location getBeforeLocation() {
        return this.beforeLocation;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.beforeLocation = this.location.clone();
        this.location = location;
    }

    /*
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
            this.setUnsafeLocation(location.clone());
            System.out.println(this.getViewers());
            System.out.println(this.getLocation());
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

     */


    public Vector getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public boolean isFire() {
        return this.fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public boolean isSneaking() {
        return this.sneaking;
    }

    public void setSneaking(boolean sneaking) {
        this.sneaking = sneaking;
    }

    public boolean isSprinting() {
        return this.sprinting;
    }

    public void setSprinting(boolean sprinting) {
        this.sprinting = sprinting;
    }

    public boolean isEating() {
        return this.eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public boolean isInvisible() {
        return this.invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public short getAirTicks() {
        return this.airTicks;
    }

    public void setAirTicks(short airTicks) {
        this.airTicks = airTicks;
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public boolean isCustomNameVisible() {
        return this.customNameVisible;
    }

    public void setCustomNameVisible(boolean customNameVisible) {
        this.customNameVisible = customNameVisible;
    }

    public boolean isSilent() {
        return this.silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }

    public boolean isInvulnerable() {
        return this.invulnerable;
    }

    public UUID getUniqueId() {
        return this.uuid;
    }

    public EntityType getEntityType() {
        return this.entityType;
    }

    public Collection<Entity> getLookAtEntity() {
        return lookAtEntity;
    }

    public void addLookAtEntity(Entity... entities) {
        this.lookAtEntity.addAll(Arrays.asList(entities));
    }

    public void removeLookAtEntity(Entity... entities) {
        this.lookAtEntity.removeAll(Arrays.asList(entities));
    }

    public boolean containsLookAtEntity(Entity entity) {
        return this.lookAtEntity.contains(entity);
    }


    public Collection<Entity> getWatchedEntity() {
        return watchedEntity;
    }

    public void addWatchedEntity(Entity... entities) {
        this.lookAtEntity.addAll(List.of(entities));
    }

    public void removeWatchedEntity(Entity... entities) {
        this.lookAtEntity.removeAll(List.of(entities));
    }

    public boolean containsWatchedEntity(Entity entity) {
        return this.watchedEntity.contains(entity);
    }

    public void addMetadataMeaning(MetadataMeaning... metadataMeanings){
        this.metadataMeanings.addAll(List.of(metadataMeanings));
    }

    public void removeMetadataMeaning(MetadataMeaning... metadataMeanings){
        this.metadataMeanings.removeAll(List.of(metadataMeanings));
    }

    public Collection<MetadataMeaning> getMetadataMeanings(){
        return this.metadataMeanings;
    }



   /*

    public Set<Player> getViewers() {
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

     */

}
