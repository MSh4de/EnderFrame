package eu.mshade.enderframe.entity;

public abstract class Boat extends Damageable {

    public abstract int getLastHit();

    public abstract void setLastHit(int time);

    public abstract int getForwardDirection();

    public abstract void setForwardDirection(int direction);
}
