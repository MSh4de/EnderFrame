package eu.mshade.enderframe.entity;

public abstract class Creeper extends LivingEntity {

    public abstract CreeperState getState();

    public abstract void setState(CreeperState state);

    public abstract boolean isPowered();

    public abstract void setPowered(boolean powered);
}
