package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Blaze extends LivingEntity {

    private boolean onFire;

    public Blaze(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean onFire) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.BLAZE, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.onFire = onFire;
    }

    public Blaze(Location location, int entityId, float health, boolean onFire) {
        super(location, EntityType.BLAZE, entityId, health);
        this.onFire = onFire;
    }

    public Blaze(Location location, int entityId){
        this(location, entityId, 10, false);
        this.onFire = false;
    }

    public boolean isOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }
}
