package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Boat extends Entity, Damageable {

    /*
    private int lastHit;
    private int forwardDirection;

    private float damageTaken;
    private Vector velocity;

     */


    int getLastHit();

    void setLastHit(int lastHit);

    int getForwardDirection();

    void setForwardDirection(int forwardDirection);

}
