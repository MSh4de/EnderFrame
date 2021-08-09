package eu.mshade.enderframe.entity;

public abstract class Enderman extends LivingEntity {

    public abstract short getCarriedBlock();

    public abstract void setCarriedBlock(short s);

    public abstract byte getCarriedBlockData();

    public abstract void setCarriedBlockData(byte carriedBlockData);

    public abstract boolean isScreaming();

    public abstract void setScreaming(boolean isScreaming);
}
