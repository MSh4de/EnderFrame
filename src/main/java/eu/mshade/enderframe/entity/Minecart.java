package eu.mshade.enderframe.entity;

public abstract class Minecart extends Damageable{

    public abstract int getShakingPower();

    public abstract void setShakingPower(int power);

    public abstract int getShakingDirection();

    public abstract void setShakingDirection(int direction);

    public abstract int getBlockId();

    public abstract void setBlockId(int blockId);

    public abstract int getBlockData();

    public abstract void setBlockData(int blockData);

    public abstract int getBlockYPosition();

    public abstract void setBlockYPosition(int blockYPosition);

    public abstract boolean showBlock();

    public abstract void setShowBlock(boolean showBlock);
}
