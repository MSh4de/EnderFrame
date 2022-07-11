package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ZombiePigman extends Zombie{


    public ZombiePigman(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.PIG_ZOMBIE);
    }

    public ZombiePigman(Location location, int entityId) {
        super(location, entityId, EntityType.PIG_ZOMBIE);
    }
}
