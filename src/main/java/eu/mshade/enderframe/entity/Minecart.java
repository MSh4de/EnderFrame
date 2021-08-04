package eu.mshade.enderframe.entity;

public interface Minecart extends Damageable{

    int getShakingPower();

    void setShakingPower(int power);

    int getShakingDirection();

    void setShakingDirection(int direction);

    int getBlockId();

    void setBlockId(int blockId);

    int getBlockData();

    void setBlockData(int blockData);

    int getBlockYPosition();

    void setBlockYPosition(int blockYPosition);

    boolean showBlock();

    void setShowBlock(boolean showBlock);
}
