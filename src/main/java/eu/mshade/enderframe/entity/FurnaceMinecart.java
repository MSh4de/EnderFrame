package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface FurnaceMinecart extends Minecart {

    //private boolean isPowered;


    boolean isPowered();

    void setPowered(boolean powered);
}
