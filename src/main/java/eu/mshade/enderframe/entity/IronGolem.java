package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface IronGolem extends LivingEntity {

    /*
    private boolean isPlayerCreated;

     */


    boolean isPlayerCreated();

    void setPlayerCreated(boolean isPlayerCreated);
}
