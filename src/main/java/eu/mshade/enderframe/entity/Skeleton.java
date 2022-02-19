package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Skeleton extends LivingEntity, ProjectileSource {

    /*
    private SkeletonType skeletonType;

     */


    SkeletonType getSkeletonType();

    void setSkeletonType(SkeletonType skeletonType);

}
