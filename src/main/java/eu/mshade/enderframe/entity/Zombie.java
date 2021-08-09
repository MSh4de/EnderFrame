package eu.mshade.enderframe.entity;

public abstract class Zombie extends LivingEntity{

    public abstract boolean isChild();

    public abstract void setChild(boolean isChild);

    public abstract boolean isVillager();

    public abstract void setVillager(boolean isVillager);

    public abstract boolean isConverting();

    public abstract void setConverting(boolean isConverting);
}
