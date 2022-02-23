package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wolf extends LivingEntity implements Tameable {


    protected boolean isAngry;
    protected boolean begging;
    protected boolean collarColor;

    public Wolf(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, boolean isAngry, boolean begging, boolean collarColor) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.isAngry = isAngry;
        this.begging = begging;
        this.collarColor = collarColor;
    }

    public boolean isAngry() {
        return this.isAngry;
    }

    public void setAngry(boolean angry) {
        this.isAngry = angry;
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
