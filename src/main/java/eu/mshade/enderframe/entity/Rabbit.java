package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Rabbit extends LivingEntity, Ageable{

    /*
    private byte rabbitType;
    private int age;
    private boolean isAgeLocked;

     */


    byte getRabbitType();

    void setRabbitType(byte rabbitType);

}
