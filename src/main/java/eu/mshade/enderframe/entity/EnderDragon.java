package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class EnderDragon extends LivingEntity {

    public EnderDragon(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ENDER_DRAGON);
    }

    public EnderDragon(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }
}
