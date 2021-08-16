package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Vector;

public interface Vehicle {

    Vector getVehicleVelocity();
    void setVehicleVelocity(Vector velocity);
}
