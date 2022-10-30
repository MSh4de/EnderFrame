package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Minecart extends Entity implements Damageable {

    /*
    protected int shakingPower;
    protected int shakingDirection;
    protected int blockId;
    protected int blockData;
    protected int blockYPosition;
    protected boolean showBlock;

     */


    public Minecart(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public Minecart(Location location, int entityId, EntityType entityType) {
        this(location, new Vector(), entityId, UUID.randomUUID(), entityType);
    }


}
