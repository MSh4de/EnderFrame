package eu.mshade.enderframe.entity;

public interface Zombie extends LivingEntity{

    boolean isChild();

    void setChild(boolean isChild);

    boolean isVillager();

    void setVillager(boolean isVillager);

    boolean isConverting();

    void setConverting(boolean isConverting);
}
