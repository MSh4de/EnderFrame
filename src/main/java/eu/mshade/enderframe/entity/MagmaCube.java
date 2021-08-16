package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class MagmaCube extends Slime{

    public MagmaCube(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte size) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.MAGMA_CUBE, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable, size);
    }

    public MagmaCube(Location location, EntityType entityType, int entityId, float health, byte size) {
        super(location, entityType, entityId, health, size);
    }

    public MagmaCube(Location location, int entityId) {
        this(location, EntityType.MAGMA_CUBE, entityId, 20f, (byte)0);
    }
}
