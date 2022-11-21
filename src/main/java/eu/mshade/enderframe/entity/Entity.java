package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;
import eu.mshade.enderframe.metadata.entity.EntityMetadataKey;
import eu.mshade.enderframe.tick.Tickable;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * use uuid for create entityID and not create dynamicly
 */

public abstract class Entity extends Tickable {

    protected Location beforeLocation, location, beforeServerLocation, serverLocation;
    protected Vector velocity;
    protected int entityId;
    protected UUID uuid;
    protected EntityType entityType;
    protected final MetadataKeyValueBucket metadataKeyValueBucket = new MetadataKeyValueBucket();
    protected Queue<Entity> lookAtEntity = new ConcurrentLinkedQueue<>();
    protected Queue<Entity> watchedEntity = new ConcurrentLinkedQueue<>();

    public Entity(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        this.beforeLocation = location.clone();
        this.location = location;
        this.beforeServerLocation = location.clone();
        this.serverLocation = location.clone();
        this.velocity = velocity;
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
    }

    public Entity(Location location, int entityId, EntityType entityType) {
        this(location, new Vector(), entityId, UUID.randomUUID(), entityType);
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

    public MetadataKeyValueBucket getMetadataKeyValueBucket() {
        return metadataKeyValueBucket;
    }


}
