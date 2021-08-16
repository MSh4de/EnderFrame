package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class IronGolem extends LivingEntity {

    private boolean isPlayerCreated;

    public IronGolem(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isPlayerCreated) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.IRON_GOLEM, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isPlayerCreated = isPlayerCreated;
    }

    public IronGolem(Location location, int entityId, float health, boolean isPlayerCreated) {
        super(location, EntityType.IRON_GOLEM, entityId, health);
        this.isPlayerCreated = isPlayerCreated;
    }

    public IronGolem(Location location, int entityId) {
        this(location, entityId, 20f, false);
    }

    public boolean isPlayerCreated() {
        return this.isPlayerCreated;
    }

    public void setPlayerCreated(boolean isPlayerCreated) {
        this.isPlayerCreated = isPlayerCreated;
    }
}
