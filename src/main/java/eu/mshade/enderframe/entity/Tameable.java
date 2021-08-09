package eu.mshade.enderframe.entity;

public abstract class Tameable extends Ageable {

    public abstract boolean isSitting();

    public abstract void setSitting(boolean isSitting);

    public abstract boolean isTame();

    public abstract void setTame(boolean isTame);

    public abstract String getOwner();
}
