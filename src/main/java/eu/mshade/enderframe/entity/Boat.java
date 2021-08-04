package eu.mshade.enderframe.entity;

public interface Boat extends Damageable {

    int getLastHit();

    void setLastHit(int time);

    int getForwardDirection();

    void setForwardDirection(int direction);
}
