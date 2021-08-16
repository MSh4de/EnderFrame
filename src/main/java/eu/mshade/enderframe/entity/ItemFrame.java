package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class ItemFrame extends Entity implements Hanging {

    private byte rotation;
    private ItemStack content;

    public ItemFrame(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, byte rotation) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ITEM_FRAME);
        this.rotation = rotation;
    }

    public ItemFrame(Location location, int entityId, byte rotation, ItemStack content) {
        super(location, EntityType.ITEM_FRAME, entityId);
        this.rotation = rotation;
        this.content = content;
    }

    public ItemFrame(Location location, int entityId) {
        this(location, entityId, (byte)0, null);
    }

    public ItemStack getItem() {
        return this.content;
    }

    public void setItem(ItemStack content) {
        this.content = content;
    }

    //Slot

    public byte getRotation() {
        return this.rotation;
    }

    public void setRotation(byte rotation) {
        this.rotation = rotation;
    }
}
