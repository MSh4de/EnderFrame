package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Squid extends LivingEntity {


    public Squid(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SQUID);
    }

    public Squid(Location location, int entityId) {
        super(location, entityId, EntityType.SQUID);
    }
}
