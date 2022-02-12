package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public interface Ghast extends LivingEntity {

    //private boolean isAttacking;


    boolean isAttacking();

    void setAttacking(boolean attacking);
}
