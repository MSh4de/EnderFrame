package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class IronGolem extends LivingEntity {

    /*
    private boolean playerCreated;

     */
    public IronGolem(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.IRON_GOLEM);
    }

    public IronGolem(Location location, int entityId) {
        super(location, entityId, EntityType.IRON_GOLEM);
    }




}
