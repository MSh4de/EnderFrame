package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Slime extends LivingEntity{

    /*
    private byte size;

     */


    byte getSize();

    void setSize(byte size);

}
