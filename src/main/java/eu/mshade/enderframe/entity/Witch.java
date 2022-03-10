package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Witch extends LivingEntity{
    /*
    protected boolean aggressive;

     */

    public Witch(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.WITCH);
    }

    public Witch(Location location, int entityId) {
        super(location, entityId, EntityType.WITCH);
    }

}
