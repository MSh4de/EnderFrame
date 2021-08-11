package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Boat extends Entity implements Damageable {

    private int lastHit;

    private int forwardDirection;

    public Boat(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, int lastHit, int forwardDirection) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers);
        this.lastHit = lastHit;
        this.forwardDirection = forwardDirection;
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
}
