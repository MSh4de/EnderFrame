package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class GiantZombie extends LivingEntity {


    public GiantZombie(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.GIANT_ZOMBIE);
    }

    public GiantZombie(Location location, int entityId) {
        super(location, entityId, EntityType.GIANT_ZOMBIE);
    }
}
