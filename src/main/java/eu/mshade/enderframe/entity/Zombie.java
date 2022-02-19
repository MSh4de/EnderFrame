package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Zombie extends LivingEntity, Ageable {

    /*
    private boolean isVillager;
    private boolean isConverting;
    private int age;
    private boolean isAgeLocked;

     */



    boolean isVillager();

    void setVillager(boolean isVillager);

    boolean isConverting();

    void setConverting(boolean isConverting);
}
