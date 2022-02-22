package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class ItemFrame extends Entity implements Hanging {


    protected byte rotation;
    protected ItemStack itemStack;

    public ItemFrame(Location beforeLocation, Location location, Vector velocity, int entityId, boolean fire, boolean sneaking, boolean sprinting, boolean eating, boolean invisible, short airTicks, String customName, boolean customNameVisible, boolean silent, boolean invulnerable, UUID uuid, EntityType entityType, byte rotation, ItemStack itemStack) {
        super(beforeLocation, location, velocity, entityId, fire, sneaking, sprinting, eating, invisible, airTicks, customName, customNameVisible, silent, invulnerable, uuid, entityType);
        this.rotation = rotation;
        this.itemStack = itemStack;
    }

    public byte getRotation() {
        return rotation;
    }

    public void setRotation(byte rotation) {
        this.rotation = rotation;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }
}
