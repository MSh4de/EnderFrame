package eu.mshade.enderframe.entity;

public interface Wither extends LivingEntity{

    int getWatchedTarget(int index);

    void setWatchedTarget(int index, int target);

    int getInvulnerableTime();

    void setInvulnerableTime(int time);
}
