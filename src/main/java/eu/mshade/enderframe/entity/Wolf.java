package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Wolf extends LivingEntity, Tameable {

    /*
    private boolean isAngry;
    private boolean begging;
    private boolean collarColor;
    private boolean isSitting;
    private boolean isTame;
    private final String owner;

     */


    boolean isAngry();

    void setAngry(boolean angry);

    boolean isBegging();

    void setBegging(boolean begging);

    boolean isCollarColor();

    void setCollarColor(boolean collarColor);

}
