package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Minecart extends Entity, Damageable {

    /*
    private int shakingPower;
    private int shakingDirection;
    private int blockId;
    private int blockData;
    private int blockYPosition;
    private boolean showBlock;
    private float damageTaken;

     */



    int getShakingPower();

    void setShakingPower(int shakingPower);

    int getShakingDirection();

    void setShakingDirection(int shakingDirection);

    int getBlockId();

    void setBlockId(int blockId);

    int getBlockData();

    void setBlockData(int blockData);

    int getBlockYPosition();

    void setBlockYPosition(int blockYPosition);

    boolean isShowBlock();

    void setShowBlock(boolean showBlock);
}
