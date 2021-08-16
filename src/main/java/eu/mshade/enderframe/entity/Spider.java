package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Spider extends LivingEntity{

    private boolean isClimbing;

    public Spider(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isClimbing) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.CAVE_SPIDER, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isClimbing = isClimbing;
    }

    public Spider(Location location, int entityId, float health, boolean isClimbing) {
        super(location, EntityType.CAVE_SPIDER, entityId, health);
        this.isClimbing = isClimbing;
    }

    public Spider(Location location, int entityId) {
        this(location, entityId, 10f, false);
    }

    public boolean isClimbing() {
        return isClimbing;
    }

    public void setClimbing(boolean climbing) {
        isClimbing = climbing;
    }
}
