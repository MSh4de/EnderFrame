package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Ghast extends LivingEntity {


    public Ghast(Location location, Vector velocity, int entityId, UUID uuid ) {
        super(location, velocity, entityId, uuid, EntityType.GHAST);
    }

    public Ghast(Location location, int entityId) {
        super(location, entityId, EntityType.GHAST);
    }

    /*
    protected boolean attacking;

     */



}

