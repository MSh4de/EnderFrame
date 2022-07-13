package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Pig extends LivingEntity implements Ageable, Rideable {


    public Pig(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.PIG);
    }

    public Pig(Location location, int entityId) {
        super(location, entityId, EntityType.PIG);
    }
}
