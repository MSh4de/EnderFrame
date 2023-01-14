package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Silverfish extends LivingEntity {


    public Silverfish(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SILVERFISH);
    }

    public Silverfish(Location location, int entityId) {
        super(location, entityId, EntityType.SILVERFISH);
    }
}
