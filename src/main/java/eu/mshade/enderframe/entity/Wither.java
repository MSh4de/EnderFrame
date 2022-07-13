package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wither extends LivingEntity {
    /*
    protected int watchedTarget;
    protected int invulnerableTime;

     */

    public Wither(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.WITHER);
    }

    public Wither(Location location, int entityId) {
        super(location, entityId, EntityType.WITHER);
    }

}
