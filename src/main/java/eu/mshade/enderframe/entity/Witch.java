package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Witch extends LivingEntity{

    /*
    private boolean isAgressive;

     */


    boolean isAgressive();

    void setAgressive(boolean agressive);
}
