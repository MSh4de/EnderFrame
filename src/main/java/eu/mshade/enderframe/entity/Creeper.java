package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Creeper extends LivingEntity {

    /*
    protected CreeperState creeperState;
    protected boolean powered;

     */

    public Creeper(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.CREEPER);
    }

    public Creeper(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }


}
