package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class MagmaCube extends Slime{


    public MagmaCube(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.MAGMA_CUBE);
    }

    public MagmaCube(Location location, int entityId) {
        super(location, entityId, EntityType.MAGMA_CUBE);
    }
}
