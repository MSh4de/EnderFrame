package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Sheep extends LivingEntity implements Ageable {

    /*
    protected Color sheepColor;
    protected boolean sheared;

     */

    public Sheep(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SHEEP);
    }

    public Sheep(Location location, int entityId) {
        super(location, entityId, EntityType.SHEEP);
    }



}
