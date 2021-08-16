package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Witch extends LivingEntity{

    private boolean isAgressive;

    public Witch(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isAgressive) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.WITCH, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isAgressive = isAgressive;
    }

    public Witch(Location location, int entityId, float health, boolean isAgressive) {
        super(location, EntityType.WITCH, entityId, health);
        this.isAgressive = isAgressive;
    }

    public Witch(Location location, int entityId) {
        this(location, entityId, 20f, false);
    }

    public boolean isAgressive() {
        return isAgressive;
    }

    public void setAgressive(boolean agressive) {
        isAgressive = agressive;
    }
}
