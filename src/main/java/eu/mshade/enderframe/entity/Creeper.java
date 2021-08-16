package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Creeper extends LivingEntity {

    private CreeperState creeperState;
    private boolean isPowered;

    public Creeper(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, CreeperState creeperState, boolean isPowered) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.CREEPER, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.creeperState = creeperState;
        this.isPowered = isPowered;
    }

    public Creeper(Location location, int entityId, float health, CreeperState creeperState, boolean isPowered){
        super(location, EntityType.CREEPER, entityId, health);
        this.creeperState = creeperState;
        this.isPowered = isPowered;
    }

    public Creeper(Location location, int entityId){
        this(location, entityId, 10, CreeperState.IDLE, false);
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
