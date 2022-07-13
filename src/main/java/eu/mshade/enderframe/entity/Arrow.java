package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Arrow extends Entity implements Projectile {

    //protected boolean critical;

    public Arrow(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ARROW);
    }

    public Arrow(Location location, int entityId) {
        super(location, new Vector(), entityId, UUID.randomUUID(), EntityType.ARROW);
    }





}
