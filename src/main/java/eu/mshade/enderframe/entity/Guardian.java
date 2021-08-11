package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Guardian extends LivingEntity {

    private boolean isElderly;
    public boolean isRetractingSpikes;
    private int targetEntityId;

    public Guardian(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isElderly, boolean isRetractingSpikes, int targetEntityId) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isElderly = isElderly;
        this.isRetractingSpikes = isRetractingSpikes;
        this.targetEntityId = targetEntityId;
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
