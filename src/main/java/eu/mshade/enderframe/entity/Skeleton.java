package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Skeleton extends LivingEntity {
    public Skeleton(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.SKELETON);
    }

    public Skeleton(Location location, int entityId) {
        super(location, entityId, EntityType.SKELETON);
    }

    /*
    protected SkeletonType skeletonType;

     */



}
