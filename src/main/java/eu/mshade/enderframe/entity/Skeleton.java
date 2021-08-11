package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Skeleton extends LivingEntity{

    private SkeletonType skeletonType;

    public Skeleton(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, SkeletonType skeletonType) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.skeletonType = skeletonType;
    }

    public SkeletonType getSkeletonType() {
        return skeletonType;
    }

    public void setSkeletonType(SkeletonType skeletonType) {
        this.skeletonType = skeletonType;
    }
}
