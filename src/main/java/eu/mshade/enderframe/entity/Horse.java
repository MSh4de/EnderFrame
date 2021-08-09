package eu.mshade.enderframe.entity;

public abstract class Horse extends Tameable {

    public abstract boolean isTame();

    public abstract void setTame(boolean isTame);

    public abstract boolean hasSaddle();

    public abstract void setSaddle(boolean hasSaddle);

    public abstract boolean hasChest();

    public abstract void setChest(boolean hasChest);

    public abstract boolean isBred();

    public abstract void setBred(boolean isBred);

    public abstract boolean isEating();

    public abstract void setEating(boolean isEating);

    public abstract boolean isRearing();

    public abstract void setRearing(boolean isRearing);

    public abstract boolean mouthOpen();

    public abstract void setMouthOpen(boolean isMouthOpen);

    public abstract HorseType getHorseType();

    public abstract void setHorseType(HorseType horseType);

    public abstract HorseColor getHorseColor();

    public abstract void setHorseColor(HorseColor horseColor);

    public abstract HorseStyle getHorseStyle();

    public abstract void setHorseStyle(HorseStyle horseStyle);

    public abstract String getOwner();

    public abstract void setOwner(String owner);

    public abstract HorseArmor getHorseArmor();

    public abstract void setHorseArmor(HorseArmor horseArmor);
}
