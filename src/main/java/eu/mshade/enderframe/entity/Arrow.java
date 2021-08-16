package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Arrow extends Entity implements Projectile {

    private boolean isCritical;
    private ProjectileSource source;
    private boolean isBouncy;

    public Arrow(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, boolean isCritical) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ARROW);
        this.isCritical = isCritical;
    }

    public Arrow(Location location, int entityId, boolean isCritical, ProjectileSource source, boolean isBouncy) {
        super(location, EntityType.ARROW, entityId);
        this.isCritical = isCritical;
        this.source = source;
        this.isBouncy = isBouncy;
    }

    public Arrow(Location location, int entityId) {
        this(location, entityId, false, null, false);
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }

    @Override
    public ProjectileSource getShooter() {
        return this.source;
    }

    @Override
    public void setShooter(ProjectileSource source) {
        this.source = source;
    }

    @Override
    public boolean doesBounce() {
        return this.isBouncy;
    }

    @Override
    public void setBounce(boolean isBouncy) {
        this.isBouncy = isBouncy;
    }
}
