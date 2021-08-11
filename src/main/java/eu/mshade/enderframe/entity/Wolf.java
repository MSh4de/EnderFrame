package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wolf extends LivingEntity implements Tameable {

    private boolean isAngry;
    private boolean begging;
    private boolean collarColor;

    public Wolf(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isAngry, boolean begging, boolean collarColor) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isAngry = isAngry;
        this.begging = begging;
        this.collarColor = collarColor;
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
}
