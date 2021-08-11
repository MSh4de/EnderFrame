package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Ocelot extends LivingEntity implements Tameable{

    private byte ocelotType;

    public Ocelot(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte ocelotType) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.ocelotType = ocelotType;
    }

    public byte getOcelotType() {
        return ocelotType;
    }

    public void setOcelotType(byte ocelotType) {
        this.ocelotType = ocelotType;
    }
}
