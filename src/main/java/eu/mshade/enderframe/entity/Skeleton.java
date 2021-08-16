package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Skeleton extends LivingEntity implements ProjectileSource {

    private SkeletonType skeletonType;

    public Skeleton(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, SkeletonType skeletonType) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.SKELETON, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.skeletonType = skeletonType;
    }

    public Skeleton(Location location, int entityId, float health, SkeletonType skeletonType) {
        super(location, EntityType.SKELETON, entityId, health);
        this.skeletonType = skeletonType;
    }

    public Skeleton(Location location, int entityId) {
        this(location, entityId, 20f, SkeletonType.NORMAL);
    }

    public SkeletonType getSkeletonType() {
        return skeletonType;
    }

    public void setSkeletonType(SkeletonType skeletonType) {
        this.skeletonType = skeletonType;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return null;
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector vector) {
        return null;
    }
}
