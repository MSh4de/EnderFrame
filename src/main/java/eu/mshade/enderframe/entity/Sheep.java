package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Sheep extends LivingEntity implements Ageable {

    private SheepColor sheepColor;
    private boolean isSheared;

    private int age;
    private boolean isAgeLocked;

    public Sheep(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, SheepColor sheepColor, boolean isSheared, int age) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.SHEEP, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.sheepColor = sheepColor;
        this.isSheared = isSheared;
        this.age = age;
    }

    public Sheep(Location location, int entityId, float health, SheepColor sheepColor, boolean isSheared, int age, boolean isAgeLocked) {
        super(location, EntityType.SHEEP, entityId, health);
        this.sheepColor = sheepColor;
        this.isSheared = isSheared;
        this.age = age;
        this.isAgeLocked = isAgeLocked;
    }

    public Sheep(Location location, int entityId) {
        this(location, entityId, 20f, SheepColor.WHITE, false, 0, false);
    }

    public SheepColor getSheepColor() {
        return sheepColor;
    }

    public void setSheepColor(SheepColor sheepColor) {
        this.sheepColor = sheepColor;
    }

    public boolean isSheared() {
        return isSheared;
    }

    public void setSheared(boolean sheared) {
        isSheared = sheared;
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
