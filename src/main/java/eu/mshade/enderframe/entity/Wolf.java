package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wolf extends LivingEntity implements Tameable {

    /*
    protected boolean isAngry;
    protected boolean begging;
    protected boolean collarColor;

     */

    public Wolf(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.WOLF);
    }

    public Wolf(Location location, int entityId) {
        super(location, entityId, EntityType.WOLF);
    }


}
