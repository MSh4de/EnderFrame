package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Rabbit extends LivingEntity implements Ageable{

    private byte rabbitType;

    private int age;
    private boolean isAgeLocked;

    public Rabbit(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, byte rabbitType) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.RABBIT, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.rabbitType = rabbitType;
    }

    public Rabbit(Location location, int entityId, float health, byte rabbitType, int age) {
        super(location, EntityType.RABBIT, entityId, health);
        this.rabbitType = rabbitType;
        this.age = age;
    }

    public Rabbit(Location location, int entityId) {
        this(location, entityId, 20f, (byte) 0, 0);
    }

    public byte getRabbitType() {
        return rabbitType;
    }

    public void setRabbitType(byte rabbitType) {
        this.rabbitType = rabbitType;
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
