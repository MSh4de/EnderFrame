package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Enderman extends LivingEntity {

    /*
    TODO change primitive block at real object Block
     */
    /*
    private short carriedBlock;
    private byte carriedBlockData;
    private boolean isScreaming;

     */


    short getCarriedBlock();

    void setCarriedBlock(short carriedBlock);

    byte getCarriedBlockData();

    void setCarriedBlockData(byte carriedBlockData);

    boolean isScreaming();

    void setScreaming(boolean isScreaming);

}