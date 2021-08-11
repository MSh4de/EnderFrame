package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Rabbit extends LivingEntity implements Ageable{

    private byte rabbityType;

    public Rabbit(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte rabbityType) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.rabbityType = rabbityType;
    }

    public byte getRabbityType() {
        return rabbityType;
    }

    public void setRabbityType(byte rabbityType) {
        this.rabbityType = rabbityType;
    }
}
