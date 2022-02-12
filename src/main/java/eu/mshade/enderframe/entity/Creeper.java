package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public interface Creeper extends LivingEntity {

    /*
    private CreeperState creeperState;
    private boolean isPowered;

     */


    CreeperState getCreeperState();

    void setCreeperState(CreeperState creeperState);

    boolean isPowered();

    void setPowered(boolean powered);

}
