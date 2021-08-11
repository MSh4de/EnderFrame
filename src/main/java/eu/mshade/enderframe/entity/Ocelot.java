package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Ocelot extends LivingEntity implements Tameable{

    private byte ocelotType;
    private boolean isSitting;
    private boolean isTame;
    private String owner;

    public Ocelot(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, EntityType entityType, Queue<Player> viewers, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte ocelotType, boolean isSitting, boolean isTame, String owner) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, entityType, viewers, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.ocelotType = ocelotType;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
    }

    public byte getOcelotType() {
        return ocelotType;
    }

    public void setOcelotType(byte ocelotType) {
        this.ocelotType = ocelotType;
    }

    @Override
    public boolean isSitting() {
        return isSitting;
    }

    @Override
    public void setSitting(boolean isSitting) {
        this.isSitting = isSitting;
    }

    @Override
    public boolean isTame() {
        return isTame;
    }

    @Override
    public void setTame(boolean isTame) {
        this.isTame = isTame;
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
