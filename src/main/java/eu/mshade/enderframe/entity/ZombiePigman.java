package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ZombiePigman extends Zombie{

    public ZombiePigman(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isChild, boolean isVillager, boolean isConverting) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable, isChild, isVillager, isConverting);
    }
}
