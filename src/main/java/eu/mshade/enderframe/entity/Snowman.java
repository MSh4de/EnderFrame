package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Snowman extends LivingEntity {

    public Snowman(Location location, int entityId, float health) {
        super(location, EntityType.SNOW_GOLEM, entityId, health);
    }

    public Snowman(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.SNOW_GOLEM, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
    }

    public Snowman(Location location, int entityId) {
        this(location, entityId, 20f);
    }
}
