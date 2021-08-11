package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Sheep extends LivingEntity implements Ageable{

    private SheepColor sheepColor;
    private boolean isSheared;

    public Sheep(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, SheepColor sheepColor, boolean isSheared) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.sheepColor = sheepColor;
        this.isSheared = isSheared;
    }

    public SheepColor getSheepColor() {
        return sheepColor;
    }

    public void setSheepColor(SheepColor sheepColor) {
        this.sheepColor = sheepColor;
    }

    public boolean isSheared() {
        return isSheared;
    }

    public void setSheared(boolean sheared) {
        isSheared = sheared;
    }
}
