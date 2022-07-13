package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class LivingEntity extends Entity {

    /*
    protected float health;
    protected int potionEffectColor;
    protected boolean potionEffectAmbient;
    protected int numberOfArrowInEntity;
    protected boolean ai;

     */


    public LivingEntity(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public LivingEntity(Location location, int entityId, EntityType entityType) {
        super(location, entityId, entityType);
    }


}
