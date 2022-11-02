package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class EnderCrystal extends Entity {

    /*
    protected int health;

     */

    public EnderCrystal(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ENDER_CRYSTAL);
    }

    public EnderCrystal(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }


}
