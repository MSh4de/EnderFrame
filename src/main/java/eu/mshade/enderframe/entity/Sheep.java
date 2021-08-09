package eu.mshade.enderframe.entity;

public abstract class Sheep extends Ageable{

    public abstract SheepColor getSheepColor();

    public abstract void setSheepColor(SheepColor sheepColor);

    public abstract boolean isSheared();

    public abstract void setSheared(boolean isSheared);
}
