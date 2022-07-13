package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class FurnaceMinecart extends Minecart {

    public FurnaceMinecart(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.FURNACE_MINECART);
    }

    public FurnaceMinecart(Location location, int entityId) {
        super(location, entityId, EntityType.FURNACE_MINECART);
    }

    /*
    protected boolean powered;

     */


}
