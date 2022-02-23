package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Zombie extends LivingEntity implements Ageable {


    protected boolean isVillager;
    protected boolean isConverting;

    public Zombie(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, boolean isVillager, boolean isConverting) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.isVillager = isVillager;
        this.isConverting = isConverting;
    }

    public boolean isVillager() {
        return this.isVillager;
    }

    public void setVillager(boolean isVillager) {
        this.isVillager = isVillager;
    }

    public boolean isConverting() {
        return this.isConverting;
    }

    public void setConverting(boolean isConverting) {
        this.isConverting = isConverting;
    }
}
