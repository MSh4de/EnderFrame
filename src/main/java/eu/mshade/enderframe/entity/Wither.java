package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Wither extends LivingEntity {

    private int watchedTarget;
    private int invulnerableTime;

    public Wither(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, int watchedTarget) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.watchedTarget = watchedTarget;
    }

    public int getWatchedTarget() {
        return watchedTarget;
    }

    public void setWatchedTarget(int watchedTarget) {
        this.watchedTarget = watchedTarget;
    }

    public int getInvulnerableTime() {
        return invulnerableTime;
    }

    public void setInvulnerableTime(int invulnerableTime) {
        this.invulnerableTime = invulnerableTime;
    }
}
