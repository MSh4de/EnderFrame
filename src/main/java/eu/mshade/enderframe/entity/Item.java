package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Item extends Entity {

    /*
    protected ItemStack itemStack;

     */

    public Item(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ITEM);
    }

    public Item(Location location, int entityId) {
        super(location, entityId, EntityType.ITEM);
    }

}
