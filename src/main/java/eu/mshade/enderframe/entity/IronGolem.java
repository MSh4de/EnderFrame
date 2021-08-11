package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class IronGolem extends LivingEntity {

    private boolean isPlayerCreated;

    public IronGolem(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isPlayerCreated) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isPlayerCreated = isPlayerCreated;
    }

    public boolean isPlayerCreated() {
        return this.isPlayerCreated;
    }

    public void setPlayerCreated(boolean isPlayerCreated) {
        this.isPlayerCreated = isPlayerCreated;
    }
}
