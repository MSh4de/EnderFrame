package eu.mshade.enderframe.entity;

public interface Sheep extends Ageable{

    SheepColor getSheepColor();

    void setSheepColor(SheepColor sheepColor);

    boolean isSheared();

    void setSheared(boolean isSheared);
}
