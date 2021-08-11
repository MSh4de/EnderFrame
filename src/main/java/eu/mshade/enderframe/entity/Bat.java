package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Bat extends LivingEntity {

    private boolean isHanging;

    public Bat(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isHanging) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isHanging = isHanging;
    }

    public boolean isHanging() {
        return isHanging;
    }

    public void setHanging(boolean isHanging) {
        this.isHanging = isHanging;
    }
}
