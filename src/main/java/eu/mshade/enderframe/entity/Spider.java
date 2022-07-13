package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Spider extends LivingEntity {

    /*
    protected boolean climbing;

     */

    protected Spider(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public Spider(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SPIDER);
    }

    public Spider(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }

}
