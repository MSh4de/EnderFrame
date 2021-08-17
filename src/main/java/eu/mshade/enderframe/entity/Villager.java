package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Villager extends LivingEntity implements Ageable{

    private VillagerType villagerType;

    private int age;
    private boolean isAgeLocked;

    public Villager(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, VillagerType villagerType, int age, boolean isAgeLocked) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.VILLAGER, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.villagerType = villagerType;
        this.age = age;
        this.isAgeLocked = isAgeLocked;
    }

    public Villager(Location location, int entityId, float health, VillagerType villagerType) {
        super(location, EntityType.VILLAGER, entityId, health);
        this.villagerType = villagerType;
    }

    public Villager(Location location, int entityId) {
        this(location, entityId, 20f, VillagerType.FARMER);
    }

    public VillagerType getVillagerType() {
        return villagerType;
    }

    public void setVillagerType(VillagerType villagerType) {
        this.villagerType = villagerType;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void setAgeLock(boolean isAgeLocked) {
        this.isAgeLocked = isAgeLocked;
    }

    @Override
    public boolean getAgeLock() {
        return this.isAgeLocked;
    }

    @Override
    public void setBaby() {
        if (this.isAdult()) {
            this.setAge(-24000);
        }
    }

    @Override
    public void setAdult() {
        if (!this.isAdult()) {
            this.setAge(0);
        }
    }

    @Override
    public boolean isAdult() {
        return this.getAge() >= 0;
    }

    @Override
    public boolean canBreed() {
        return this.getAge() == 0;
    }

    @Override
    public void setBreed(boolean isBreedable) {
        if (isBreedable) this.setAge(0);
        else this.setAge(6000);
    }
}
