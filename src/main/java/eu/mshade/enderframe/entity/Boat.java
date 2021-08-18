package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Boat extends Entity implements Damageable {

    private int lastHit;
    private int forwardDirection;

    private float damageTaken;
    private Vector velocity;

    public Boat(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, int lastHit, int forwardDirection, float damageTaken) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.BOAT);
        this.lastHit = lastHit;
        this.forwardDirection = forwardDirection;
        this.damageTaken = damageTaken;
    }

    public Boat(Location location, int entityId, int lastHit, int forwardDirection, float damageTaken) {
        super(location, EntityType.BOAT, entityId);
        this.lastHit = lastHit;
        this.forwardDirection = forwardDirection;
        this.damageTaken = damageTaken;
    }

    public Boat(Location location, int entityId){
        this(location, entityId, 0, 0, 0);
    }

    public int getLastHit() {
        return lastHit;
    }

    public void setLastHit(int lastHit) {
        this.lastHit = lastHit;
    }

    public int getForwardDirection() {
        return forwardDirection;
    }

    public void setForwardDirection(int forwardDirection) {
        this.forwardDirection = forwardDirection;
    }

    @Override
    public float getDamageTaken() {
        return damageTaken;
    }

    @Override
    public void setDamageTaken(float damageTaken) {
        this.damageTaken = damageTaken;
    }
}
