package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.inventory.ClickType;
import eu.mshade.enderframe.inventory.Inventory;

public class PacketInventoryClickEvent implements PacketEvent {

    protected Inventory inventory;
    protected ClickType clickType;
    protected int slot;
    protected int key;

    public PacketInventoryClickEvent(Inventory inventory, ClickType clickType, int slot, int key) {
        this.inventory = inventory;
        this.clickType = clickType;
        this.slot = slot;
        this.key = key;
    }

    public PacketInventoryClickEvent(Inventory inventory, ClickType clickType, int slot) {
        this.inventory = inventory;
        this.clickType = clickType;
        this.slot = slot;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public int getSlot() {
        return slot;
    }

    public int getKey() {
        return key;
    }
}
