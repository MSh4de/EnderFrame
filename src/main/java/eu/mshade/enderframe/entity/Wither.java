package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wither extends LivingEntity {

    private int watchedTarget;
    private int invulnerableTime;

    public Wither(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, int watchedTarget, int invulnerableTime) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.watchedTarget = watchedTarget;
        this.invulnerableTime = invulnerableTime;
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
