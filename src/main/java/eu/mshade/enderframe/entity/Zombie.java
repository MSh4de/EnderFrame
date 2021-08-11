package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Zombie extends LivingEntity implements Ageable{

    private boolean isChild;
    private boolean isVillager;
    private boolean isConverting;

    public Zombie(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isChild, boolean isVillager, boolean isConverting) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isChild = isChild;
        this.isVillager = isVillager;
        this.isConverting = isConverting;
    }

    public boolean isChild() {
        return this.isChild;
    }

    public void setChild(boolean isChild) {
        this.isChild = isChild;
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
