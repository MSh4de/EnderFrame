package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public interface Blaze extends LivingEntity {

    //private boolean onFire;

    boolean isOnFire();

    void setOnFire(boolean onFire);
}
