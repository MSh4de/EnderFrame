package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.tick.Tickable;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * use uuid for create entityID and not create dynamicly
 */

public abstract class Entity extends Tickable {

    //beforeLocation & location = Client
    //beforeServerLocation & serverLocation = Tick
    protected Location beforeLocation, location, beforeServerLocation, serverLocation;
    protected Vector velocity;
    protected int entityId;
    protected UUID uuid;
    protected EntityKey entityKey;
    protected final MetadataKeyValueBucket metadataKeyValueBucket = new MetadataKeyValueBucket();
    protected Queue<Entity> lookAtEntity = new ConcurrentLinkedQueue<>();
    protected Queue<Entity> watchedEntity = new ConcurrentLinkedQueue<>();

    public Entity(Location location, Vector velocity, int entityId, UUID uuid, EntityKey entityKey) {
        this.beforeLocation = location.clone();
        this.location = location;
        this.beforeServerLocation = location.clone();
        this.serverLocation = location.clone();
        this.velocity = velocity;
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityKey = entityKey;
    }

    public Entity(Location location, int entityId, EntityKey entityKey) {
        this(location, new Vector(), entityId, UUID.randomUUID(), entityKey);
    }

    public void tick() {
        if (location.equals(serverLocation))
            return;

        this.beforeServerLocation = serverLocation.clone();
        this.serverLocation = location.clone();

        this.watchedEntity.stream().filter(entity -> entity instanceof Player).forEach(player -> {
            ((Player) player).getSessionWrapper().sendMove(this, beforeServerLocation, serverLocation);
        });
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

    public Location getBeforeServerLocation() {
        return beforeServerLocation;
    }

    public Location getServerLocation() {
        return serverLocation;
    }

    public void setServerLocation(Location location) {
        this.beforeServerLocation = this.serverLocation.clone();
        this.serverLocation = location;
    }

    public Vector getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public UUID getUniqueId() {
        return this.uuid;
    }

    public EntityKey getEntityKey() {
        return this.entityKey;
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

    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
    }
}
