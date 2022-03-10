package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Firework extends Entity {


    public Firework(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.FIREWORK_ROCKET);
    }


    public Firework(Location location, int entityId) {
        super(location, new Vector(), entityId, UUID.randomUUID(), EntityType.FIREWORK_ROCKET);
    }


    //Slot
}
