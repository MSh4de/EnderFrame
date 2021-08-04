package eu.mshade.enderframe.entity;

public interface Horse extends Tameable {

    boolean isTame();

    void setTame(boolean isTame);

    boolean hasSaddle();

    void setSaddle(boolean hasSaddle);

    boolean hasChest();

    void setChest(boolean hasChest);

    boolean isBred();

    void setBred(boolean isBred);

    boolean isEating();

    void setEating(boolean isEating);

    boolean isRearing();

    void setRearing(boolean isRearing);

    boolean mouthOpen();

    void setMouthOpen(boolean isMouthOpen);

    HorseType getHorseType();

    void setHorseType(HorseType horseType);

    HorseColor getHorseColor();

    void setHorseColor(HorseColor horseColor);

    HorseStyle getHorseStyle();

    void setHorseStyle(HorseStyle horseStyle);

    String getOwner();

    void setOwner(String owner);

    HorseArmor getHorseArmor();

    void setHorseArmor(HorseArmor horseArmor);
}
