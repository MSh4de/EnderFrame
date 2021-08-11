package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Pig extends LivingEntity implements Ageable{

    private boolean hasSaddle;

    public Pig(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean hasSaddle) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.hasSaddle = hasSaddle;
    }

    public boolean isHasSaddle() {
        return hasSaddle;
    }

    public void setHasSaddle(boolean hasSaddle) {
        this.hasSaddle = hasSaddle;
    }
}
