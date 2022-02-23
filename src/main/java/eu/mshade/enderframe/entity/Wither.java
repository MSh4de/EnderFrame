package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Wither extends LivingEntity {

    protected int watchedTarget;
    protected int invulnerableTime;

    public Wither(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, int watchedTarget, int invulnerableTime) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
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
