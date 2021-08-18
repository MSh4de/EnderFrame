package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Guardian extends LivingEntity {

    private boolean isElderly;
    private boolean isRetractingSpikes;
    private int targetEntityId;


    public Guardian(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isElderly, boolean isRetractingSpikes, int targetEntityId) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.GUARDIAN, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isElderly = isElderly;
        this.isRetractingSpikes = isRetractingSpikes;
        this.targetEntityId = targetEntityId;
    }

    public Guardian(Location location, int entityId, float health, boolean isElderly, boolean isRetractingSpikes) {
        super(location, EntityType.GUARDIAN, entityId, health);
        this.isElderly = isElderly;
        this.isRetractingSpikes = isRetractingSpikes;
        this.targetEntityId = 0;
    }

    public Guardian(Location location, int entityId) {
        this(location, entityId, 20f, false, false);
    }

    public boolean isElderly() {
        return isElderly;
    }

    public void setElderly(boolean elderly) {
        isElderly = elderly;
    }

    public boolean isRetractingSpikes() {
        return isRetractingSpikes;
    }

    public void setRetractingSpikes(boolean retractingSpikes) {
        isRetractingSpikes = retractingSpikes;
    }

    public int getTargetEntityId() {
        return targetEntityId;
    }

    public void setTargetEntityId(int targetEntityId) {
        this.targetEntityId = targetEntityId;
    }
}
