package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Wither extends LivingEntity {

    /*
    private int watchedTarget;
    private int invulnerableTime;

     */


    int getWatchedTarget();

    void setWatchedTarget(int watchedTarget);

    int getInvulnerableTime();

    void setInvulnerableTime(int invulnerableTime);
}
