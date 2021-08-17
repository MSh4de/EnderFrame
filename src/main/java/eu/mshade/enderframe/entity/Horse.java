package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Horse extends LivingEntity implements Tameable, Ageable {

    private boolean hasSaddle;
    private boolean hasChest;
    private boolean isBred;
    private boolean isRearing;
    private boolean mouthOpen;
    private HorseType horseType;
    private HorseColor horseColor;
    private HorseStyle horseStyle;
    private HorseArmor horseArmor;
    private boolean isSitting;
    private boolean isTame;
    private final String owner;

    private boolean isAgeLocked;
    private int age;

    public Horse(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, float health, int potionEffectColor, boolean isPotionEffectAmbient, byte numberOfArrowInEntity, boolean isAIDisable, boolean hasSaddle, boolean hasChest, boolean isBred, boolean isRearing, boolean mouthOpen, HorseType horseType, HorseColor horseColor, HorseStyle horseStyle, HorseArmor horseArmor, boolean isSitting, boolean isTame, String owner, int age) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.HORSE, health, potionEffectColor, isPotionEffectAmbient, numberOfArrowInEntity, isAIDisable);
        this.hasSaddle = hasSaddle;
        this.hasChest = hasChest;
        this.isBred = isBred;
        this.isRearing = isRearing;
        this.mouthOpen = mouthOpen;
        this.horseType = horseType;
        this.horseColor = horseColor;
        this.horseStyle = horseStyle;
        this.horseArmor = horseArmor;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
        this.age = age;
    }

    public Horse(Location location, int entityId, float health, boolean hasSaddle, boolean hasChest, boolean isBred, boolean isRearing, boolean mouthOpen, HorseType horseType, HorseColor horseColor, HorseStyle horseStyle, HorseArmor horseArmor, boolean isSitting, boolean isTame, String owner, boolean isAgeLocked, int age, Vector vehicleVelocity) {
        super(location, EntityType.HORSE, entityId, health);
        this.hasSaddle = hasSaddle;
        this.hasChest = hasChest;
        this.isBred = isBred;
        this.isRearing = isRearing;
        this.mouthOpen = mouthOpen;
        this.horseType = horseType;
        this.horseColor = horseColor;
        this.horseStyle = horseStyle;
        this.horseArmor = horseArmor;
        this.isSitting = isSitting;
        this.isTame = isTame;
        this.owner = owner;
        this.isAgeLocked = isAgeLocked;
        this.age = age;
    }

    public Horse(Location location, int entityId) {
        this(location, entityId, 20f, false, false, false, false, false, HorseType.HORSE, HorseColor.BLACK, HorseStyle.NONE, HorseArmor.NO_ARMOR, false, false, null, false, 0, new Vector());
    }

    public boolean isHasSaddle() {
        return hasSaddle;
    }

    public void setHasSaddle(boolean hasSaddle) {
        this.hasSaddle = hasSaddle;
    }

    public boolean isHasChest() {
        return hasChest;
    }

    public void setHasChest(boolean hasChest) {
        this.hasChest = hasChest;
    }

    public boolean isBred() {
        return isBred;
    }

    public void setBred(boolean bred) {
        isBred = bred;
    }

    public boolean isRearing() {
        return isRearing;
    }

    public void setRearing(boolean rearing) {
        isRearing = rearing;
    }

    public boolean isMouthOpen() {
        return mouthOpen;
    }

    public void setMouthOpen(boolean mouthOpen) {
        this.mouthOpen = mouthOpen;
    }

    public HorseType getHorseType() {
        return horseType;
    }

    public void setHorseType(HorseType horseType) {
        this.horseType = horseType;
    }

    public HorseColor getHorseColor() {
        return horseColor;
    }

    public void setHorseColor(HorseColor horseColor) {
        this.horseColor = horseColor;
    }

    public HorseStyle getHorseStyle() {
        return horseStyle;
    }

    public void setHorseStyle(HorseStyle horseStyle) {
        this.horseStyle = horseStyle;
    }

    public HorseArmor getHorseArmor() {
        return horseArmor;
    }

    public void setHorseArmor(HorseArmor horseArmor) {
        this.horseArmor = horseArmor;
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
