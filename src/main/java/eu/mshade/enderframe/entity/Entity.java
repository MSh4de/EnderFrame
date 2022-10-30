package eu.mshade.enderframe.entity;

import eu.mshade.enderchest.entity.AgeEntityMetadataAdapter;
import eu.mshade.enderchest.entity.BreedableEntityMetadataAdapter;
import eu.mshade.enderchest.entity.TameableEntityMetadataAdapter;
import eu.mshade.enderframe.entity.metadata.AgeEntityMetadata;
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

    protected Location beforeLocation, location, tickBeforeLocation, tickLocation;
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
        this.tickBeforeLocation = location.clone();
        this.tickLocation = location.clone();
        this.velocity = velocity;
        this.entityId = entityId;
        this.uuid = uuid;
        this.entityType = entityType;
    }

    public Entity(Location location, int entityId, EntityType entityType) {
        this(location, new Vector(), entityId, UUID.randomUUID(), entityType);
    }

    public void tick() {
        if (location.equals(tickLocation))
            return;

        this.tickBeforeLocation = tickLocation.clone();
        this.tickLocation = location.clone();

        this.watchedEntity.stream().filter(entity -> entity instanceof Player).forEach(player -> {
            ((Player) player).getSessionWrapper().sendMove(this, tickBeforeLocation, tickLocation);
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

    public Location getTickBeforeLocation() {
        return tickBeforeLocation;
    }

    public Location getTickLocation() {
        return tickLocation;
    }

    public void setTickLocation(Location location) {
        this.tickBeforeLocation = this.tickLocation.clone();
        this.tickLocation = location;
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

    public AgeEntityMetadataAdapter toAgeAdapter() {
        return new AgeEntityMetadataAdapter(this);
    }

    public BreedableEntityMetadataAdapter toBreedableAdapter() {
        return new BreedableEntityMetadataAdapter(this);
    }

    public TameableEntityMetadataAdapter toTameableAdapter() {
        return new TameableEntityMetadataAdapter(this);
    }
}
