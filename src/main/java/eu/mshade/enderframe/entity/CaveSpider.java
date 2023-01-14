package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class CaveSpider extends Spider {

    public CaveSpider(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.CAVE_SPIDER);
    }

    public CaveSpider(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }
}
