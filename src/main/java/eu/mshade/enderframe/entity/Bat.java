package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public interface Bat extends LivingEntity {

    //private boolean isHanging;


    boolean isHanging();

    void setHanging(boolean isHanging);
}
