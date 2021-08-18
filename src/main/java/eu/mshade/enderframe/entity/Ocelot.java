package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Ocelot extends LivingEntity implements Tameable {

    private byte ocelotType;
    private boolean isSitting;
    private boolean isTame;
    private final String owner;

    public Ocelot(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte ocelotType, boolean isSitting, boolean isTame, String owner) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.OCELOT, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.ocelotType = ocelotType;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
    }

    public Ocelot(Location location, int entityId, float health, byte ocelotType, boolean isSitting, boolean isTame, String owner) {
        super(location, EntityType.OCELOT, entityId, health);
        this.ocelotType = ocelotType;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
    }
    
    public Ocelot(Location location, int entityId) {
        this(location, entityId, 20f, (byte) 0, false, false, null);
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
    public boolean isTamed() {
        return isTame;
    }

    @Override
    public void setTamed(boolean isTamed) {
        this.isTame = isTamed;
    }

    @Override
    public String getOwner() {
        return owner;
    }
}
