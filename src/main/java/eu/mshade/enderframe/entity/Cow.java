package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Cow extends LivingEntity implements Ageable, Breedable {

    public Cow(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.COW);
    }

    public Cow(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }
}
