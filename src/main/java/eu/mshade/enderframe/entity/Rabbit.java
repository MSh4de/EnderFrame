package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Rabbit extends LivingEntity implements Ageable {

    /*
    protected byte rabbitType;

     */

    public Rabbit(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.RABBIT);
    }

    public Rabbit(Location location, int entityId) {
        super(location, entityId, EntityType.RABBIT);
    }


}
