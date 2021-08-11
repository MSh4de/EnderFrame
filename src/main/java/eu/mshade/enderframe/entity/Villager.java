package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Villager extends LivingEntity implements Ageable{

    private VillagerType villagerType;

    public Villager(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, VillagerType villagerType) {
        super(location, velocity, entityId, uuid, entityType, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.villagerType = villagerType;
    }

    public VillagerType getVillagerType() {
        return villagerType;
    }

    public void setVillagerType(VillagerType villagerType) {
        this.villagerType = villagerType;
    }
}
