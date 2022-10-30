package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.inventory.ClickType;
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.item.ItemStack;

public class PacketClickInventoryEvent implements PacketEvent {

    protected Inventory inventory;
    protected ClickType clickType;
    protected ItemStack itemStack;
    protected int slot;
    protected int key;

    public PacketClickInventoryEvent(Inventory inventory, ClickType clickType, ItemStack itemStack, int slot, int key) {
        this.inventory = inventory;
        this.clickType = clickType;
        this.itemStack = itemStack;
        this.slot = slot;
        this.key = key;
    }

    public PacketClickInventoryEvent(Inventory inventory, ClickType clickType, ItemStack itemStack, int slot) {
        this.inventory = inventory;
        this.clickType = clickType;
        this.itemStack = itemStack;
        this.slot = slot;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "PacketInventoryClickEvent{" +
                "inventory=" + inventory +
                ", clickType=" + clickType +
                ", itemStack=" + itemStack +
                ", slot=" + slot +
                ", key=" + key +
                '}';
    }
}
