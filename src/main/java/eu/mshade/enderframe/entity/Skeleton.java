package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Skeleton extends LivingEntity implements ProjectileSource {

    protected SkeletonType skeletonType;

    public Skeleton(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, SkeletonType skeletonType) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.skeletonType = skeletonType;
    }

    public SkeletonType getSkeletonType() {
        return skeletonType;
    }

    public void setSkeletonType(SkeletonType skeletonType) {
        this.skeletonType = skeletonType;
    }

}
