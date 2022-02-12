package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Spider extends LivingEntity {

    //private boolean isClimbing;

    boolean isClimbing();

    void setClimbing(boolean climbing);

}
