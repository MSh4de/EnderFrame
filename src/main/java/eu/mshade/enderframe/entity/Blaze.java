package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Blaze extends LivingEntity {

    //protected boolean onFire;

    public Blaze(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.BLAZE);
    }

    public Blaze(Location location, int entityId) {
        super(location, new Vector(), entityId, UUID.randomUUID(), EntityType.BLAZE);
    }
  
}
