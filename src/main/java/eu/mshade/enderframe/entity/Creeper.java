package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Creeper extends LivingEntity {

    private CreeperState creeperState;
    private boolean isPowered;

    public Creeper(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, CreeperState creeperState, boolean isPowered) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.creeperState = creeperState;
        this.isPowered = isPowered;
    }

    public CreeperState getCreeperState() {
        return creeperState;
    }

    public void setCreeperState(CreeperState creeperState) {
        this.creeperState = creeperState;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }
}
