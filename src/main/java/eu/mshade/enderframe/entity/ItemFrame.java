package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ItemFrame extends Entity implements Hanging {

    /*
    protected byte rotation;
    protected ItemStack itemStack;

     */

    public ItemFrame(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ITEM_FRAME);
    }

    public ItemFrame(Location location, int entityId) {
        super(location, entityId, EntityType.ITEM_FRAME);
    }

}
