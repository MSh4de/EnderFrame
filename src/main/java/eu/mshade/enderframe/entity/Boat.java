package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Boat extends Entity implements Damageable {

    protected int lastHit;
    protected int forwardDirection;

    public Boat(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, int lastHit, int forwardDirection) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType);
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
