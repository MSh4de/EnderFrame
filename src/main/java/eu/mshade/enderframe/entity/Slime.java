package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Slime extends LivingEntity{

    private byte size;

    public Slime(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte size) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.size = size;
    }

    public Slime(Location location, EntityType entityType, int entityId, float health, byte size) {
        super(location, entityType, entityId, health);
        this.size = size;
    }

    public Slime(Location location, int entityId) {
        this(location, EntityType.SLIME, entityId, 20f, (byte)0);
    }

    public byte getSize() {
        return this.size;
    }

    public void setSize(byte size) {
        this.size = size;
    }

}
