package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Horse extends LivingEntity, Tameable, Ageable {

    /*
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

     */


    boolean isHasSaddle();

    void setHasSaddle(boolean hasSaddle);

    boolean isHasChest();

    void setHasChest(boolean hasChest);

    boolean isBred();

    void setBred(boolean bred);

    boolean isRearing();

    void setRearing(boolean rearing);

    boolean isMouthOpen();

    void setMouthOpen(boolean mouthOpen);

    HorseType getHorseType();

    void setHorseType(HorseType horseType);

    HorseColor getHorseColor();

    void setHorseColor(HorseColor horseColor);

    HorseStyle getHorseStyle();

    void setHorseStyle(HorseStyle horseStyle);

    HorseArmor getHorseArmor();

    void setHorseArmor(HorseArmor horseArmor);

}
