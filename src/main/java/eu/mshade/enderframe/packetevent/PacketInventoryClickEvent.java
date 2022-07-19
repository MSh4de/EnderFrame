package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.inventory.ClickType;
import eu.mshade.enderframe.inventory.Inventory;

public class PacketInventoryClickEvent implements PacketEvent {

    protected Inventory inventory;
    protected ClickType clickType;
    protected int slot;
    protected int key;
    

}
