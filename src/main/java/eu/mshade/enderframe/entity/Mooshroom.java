package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Mooshroom extends LivingEntity {


    public Mooshroom(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.MOOSHROOM);
    }

    public Mooshroom(Location location, int entityId) {
        super(location, entityId, EntityType.MOOSHROOM);
    }
}
