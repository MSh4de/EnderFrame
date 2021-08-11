package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Slime extends LivingEntity{

    private byte size;

    public Slime(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte size) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.size = size;
    }

    public byte size() {
        return this.size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

}
