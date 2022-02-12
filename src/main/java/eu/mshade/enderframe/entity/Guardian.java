package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Guardian extends LivingEntity {

    /*
    private boolean isElderly;
    private boolean isRetractingSpikes;
    private int targetEntityId;

     */



    boolean isElderly();

    void setElderly(boolean elderly);

    boolean isRetractingSpikes();

    void setRetractingSpikes(boolean retractingSpikes);

    int getTargetEntityId();

    void setTargetEntityId(int targetEntityId);

}
