package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Bat extends LivingEntity {

    //protected boolean hanging;

    public Bat(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.BAT);
    }

    public Bat(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }

}
