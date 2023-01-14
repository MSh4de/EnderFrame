package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Ocelot extends LivingEntity implements Tameable {
    public Ocelot(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.OCELOT);
    }

    public Ocelot(Location location, int entityId) {
        super(location, entityId, EntityType.OCELOT);
    }
    /*
    protected byte ocelotType;

     */




}
