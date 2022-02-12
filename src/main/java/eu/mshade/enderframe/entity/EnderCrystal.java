package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface EnderCrystal extends Entity {

    //private int health;


    int getHealth();

    void setHealth(int health);
}
