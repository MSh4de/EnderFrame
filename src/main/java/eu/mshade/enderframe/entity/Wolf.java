package eu.mshade.enderframe.entity;

public abstract class Wolf extends Tameable {

    public abstract boolean isAngry();

    public abstract void setIsAngry(boolean isAngry);

    public abstract float getHealth();

    public abstract void setHealth(float health);

    public abstract boolean begging();

    public abstract void setBegging(boolean begging);

    public abstract boolean getCollarColor();

    public abstract void setCollarColor(boolean collarColor);
}
