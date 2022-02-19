package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Villager extends LivingEntity, Ageable{

    /*
    private VillagerType villagerType;

    private int age;
    private boolean isAgeLocked;

     */


    VillagerType getVillagerType();

    void setVillagerType(VillagerType villagerType);

}
