package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Zombie extends LivingEntity implements Ageable {

    private boolean isVillager;
    private boolean isConverting;
    private boolean isAgeLocked;
    private int age;

    public Zombie(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean isVillager, boolean isConverting, int age, boolean isAgeLocked) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ZOMBIE, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.isVillager = isVillager;
        this.isConverting = isConverting;
        this.age = age;
        this.isAgeLocked = isAgeLocked;
    }

    public Zombie(Location location, int entityId, float health, boolean isVillager, boolean isConverting, boolean isAgeLocked, int age) {
        super(location, EntityType.ZOMBIE, entityId, health);
        this.isVillager = isVillager;
        this.isConverting = isConverting;
        this.age = age;
        this.isAgeLocked = isAgeLocked;
    }

    public boolean isVillager() {
        return this.isVillager;
    }

    public void setVillager(boolean isVillager) {
        this.isVillager = isVillager;
    }

    public boolean isConverting() {
        return this.isConverting;
    }

    public void setConverting(boolean isConverting) {
        this.isConverting = isConverting;
    }

    @Override
    public void setAgeLock(boolean ageLock) {
        this.isAgeLocked = ageLock;
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

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
