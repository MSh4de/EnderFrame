package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class LivingEntity extends Entity {

    private float health;
    private int potionEffectColor;
    private boolean isPotionEffectAmbient;
    private byte numberOfArrowInEntity;
    private boolean isAIDisable;

    public LivingEntity(Location location, EntityType entityType, int entityId, float health) {
        super(location, entityType, entityId);
        this.health = health;
        this.potionEffectColor = 0;
        this.isPotionEffectAmbient = false;
        this.numberOfArrowInEntity = 0;
        this.isAIDisable = false;
    }

    public LivingEntity(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers);
        this.health = health;
        this.potionEffectColor = potionEffectColor;
        this.isPotionEffectAmbient = isPotionEffectAmbient;
        this.numberOfArrowInEntity = numberOfArrowInEntity;
        this.isAIDisable = isAIDisable;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getPotionEffectColor() {
        return potionEffectColor;
    }

    public void setPotionEffectColor(int potionEffectColor) {
        this.potionEffectColor = potionEffectColor;
    }

    public boolean isPotionEffectAmbient() {
        return isPotionEffectAmbient;
    }

    public void setPotionEffectAmbient(boolean potionEffectAmbient) {
        isPotionEffectAmbient = potionEffectAmbient;
    }

    public byte getNumberOfArrowInEntity() {
        return numberOfArrowInEntity;
    }

    public void setNumberOfArrowInEntity(byte numberOfArrowInEntity) {
        this.numberOfArrowInEntity = numberOfArrowInEntity;
    }

    public boolean isAIDisable() {
        return isAIDisable;
    }

    public void setAIDisable(boolean AIDisable) {
        isAIDisable = AIDisable;
    }
}
