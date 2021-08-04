package eu.mshade.enderframe.entity;

public interface Creeper extends LivingEntity{

    CreeperState getState();

    void setState(CreeperState state);

    boolean isPowered();

    void setPowered(boolean powered);
}
