package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Ocelot extends LivingEntity, Tameable {

    /*
    private byte ocelotType;
    private boolean isSitting;
    private boolean isTame;
    private final String owner;

     */



    byte getOcelotType();

    void setOcelotType(byte ocelotType);

}
