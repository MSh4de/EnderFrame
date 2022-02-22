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

    public Horse(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, float health, int potionEffectColor, boolean potionEffectAmbient, byte numberOfArrowInEntity, boolean ai, boolean hasSaddle, boolean hasChest, boolean isBred, boolean isRearing, boolean mouthOpen, HorseType horseType, HorseColor horseColor, HorseStyle horseStyle, HorseArmor horseArmor) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType, health, potionEffectColor, potionEffectAmbient, numberOfArrowInEntity, ai);
        this.hasSaddle = hasSaddle;
        this.hasChest = hasChest;
        this.isBred = isBred;
        this.isRearing = isRearing;
        this.mouthOpen = mouthOpen;
        this.horseType = horseType;
        this.horseColor = horseColor;
        this.horseStyle = horseStyle;
        this.horseArmor = horseArmor;
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


}
