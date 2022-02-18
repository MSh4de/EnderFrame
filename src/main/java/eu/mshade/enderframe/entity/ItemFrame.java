package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Rotation;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public interface ItemFrame extends Entity, Hanging {

    /*
    private byte rotation;
    private ItemStack content;

     */

    ItemStack getItem();

    void setItem(ItemStack content);

    //Slot

    byte getRotation();

    void setRotation(byte rotation);
}
