package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Enderman extends LivingEntity {

    /*
    TODO change primitive block at real object Block

    protected short carriedBlock;
    protected byte carriedBlockData;
    protected boolean screaming;

     */

    public Enderman(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ENDERMAN);
    }

    public Enderman(Location location, int entityId) {
        this(location, new Vector(), entityId, UUID.randomUUID());
    }




}