package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Boat extends Entity implements Damageable {

    /*
    protected int lastHit;
    protected int forwardDirection;

     */

    public Boat(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.BOAT);
    }

    public Boat(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }



}
