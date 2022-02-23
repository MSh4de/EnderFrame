package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.mojang.Color;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Sheep extends LivingEntity implements Ageable {

    protected Color sheepColor;
    protected boolean sheared;

    public Sheep(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, Color sheepColor, boolean sheared) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.sheepColor = sheepColor;
        this.sheared = sheared;
    }

    public Color getSheepColor() {
        return sheepColor;
    }

    public void setSheepColor(Color sheepColor) {
        this.sheepColor = sheepColor;
    }

    public boolean isSheared() {
        return sheared;
    }

    public void setSheared(boolean sheared) {
        this.sheared = sheared;
    }

}
