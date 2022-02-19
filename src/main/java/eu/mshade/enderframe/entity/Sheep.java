package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.mojang.Color;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Sheep extends LivingEntity, Ageable {

    /*
    private SheepColor sheepColor;
    private boolean isSheared;

    private int age;
    private boolean isAgeLocked;

     */


    Color getSheepColor();

    void setSheepColor(Color sheepColor);

    boolean isSheared();

    void setSheared(boolean sheared);
}
