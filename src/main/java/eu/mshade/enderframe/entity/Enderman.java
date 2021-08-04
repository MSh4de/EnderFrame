package eu.mshade.enderframe.entity;

public interface Enderman extends LivingEntity{

    short getCarriedBlock();

    void setCarriedBlock(short s);

    byte getCarriedBlockData();

    void setCarriedBlockData(byte carriedBlockData);

    boolean isScreaming();

    void setScreaming(boolean isScreaming);
}
