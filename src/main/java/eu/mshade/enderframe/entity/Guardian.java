package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Guardian extends LivingEntity {

    protected boolean elderly;
    protected boolean retractingSpikes;
    protected int targetEntityId;

    public Guardian(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, boolean elderly, boolean retractingSpikes, int targetEntityId) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.elderly = elderly;
        this.retractingSpikes = retractingSpikes;
        this.targetEntityId = targetEntityId;
    }

    public boolean isElderly() {
        return elderly;
    }

    public void setElderly(boolean elderly) {
        this.elderly = elderly;
    }

    public boolean isRetractingSpikes() {
        return retractingSpikes;
    }

    public void setRetractingSpikes(boolean retractingSpikes) {
        this.retractingSpikes = retractingSpikes;
    }

    public int getTargetEntityId() {
        return targetEntityId;
    }

    public void setTargetEntityId(int targetEntityId) {
        this.targetEntityId = targetEntityId;
    }

}
