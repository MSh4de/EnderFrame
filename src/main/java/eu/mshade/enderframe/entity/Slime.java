package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Slime extends LivingEntity{

    public Slime(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public Slime(Location location, int entityId, EntityType entityType) {
        super(location, entityId, entityType);
    }

    public Slime(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SLIME);
    }

    public Slime(Location location, int entityId) {
        super(location, entityId, EntityType.SLIME);
    }




    /*
    protected byte size;

     */



}
