package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wolf extends LivingEntity implements Tameable {

    private boolean isAngry;
    private boolean begging;
    private boolean collarColor;
    private boolean isSitting;
    private boolean isTame;
    private final String owner;

    public Wolf(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isAngry, boolean begging, boolean collarColor, boolean isSitting, boolean isTame, String owner) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.WOLF, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isAngry = isAngry;
        this.begging = begging;
        this.collarColor = collarColor;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
    }

    public Wolf(Location location, int entityId, float health, boolean isAngry, boolean begging, boolean collarColor, boolean isSitting, boolean isTame, String owner) {
        super(location, EntityType.WOLF, entityId, health);
        this.isAngry = isAngry;
        this.begging = begging;
        this.collarColor = collarColor;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
    }

    public Wolf(Location location, int entityId) {
        this(location, entityId, 20f, false, false, false, false, false, null);
    }

    public boolean isAngry() {
        return isAngry;
    }

    public void setAngry(boolean angry) {
        isAngry = angry;
    }

    public boolean isBegging() {
        return begging;
    }

    public void setBegging(boolean begging) {
        this.begging = begging;
    }

    public boolean isCollarColor() {
        return collarColor;
    }

    public void setCollarColor(boolean collarColor) {
        this.collarColor = collarColor;
    }

    @Override
    public boolean isSitting() {
        return isSitting;
    }

    @Override
    public void setSitting(boolean isSitting) {
        this.isSitting = isSitting;
    }

    @Override
    public boolean isTame() {
        return isTame;
    }

    @Override
    public void setTame(boolean isTame) {
        this.isTame = isTame;
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
