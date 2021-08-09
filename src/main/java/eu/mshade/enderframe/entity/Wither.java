package eu.mshade.enderframe.entity;

public abstract class Wither extends LivingEntity {

    public abstract int getWatchedTarget(int index);

    public abstract void setWatchedTarget(int index, int target);

    public abstract int getInvulnerableTime();

    public abstract void setInvulnerableTime(int time);
}
