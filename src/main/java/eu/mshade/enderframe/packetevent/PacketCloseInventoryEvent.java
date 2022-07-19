package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.inventory.Inventory;

public class PacketCloseInventoryEvent implements PacketEvent {

    protected Inventory inventory;

    public PacketCloseInventoryEvent(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "PacketCloseInventoryEvent{" +
                "inventory=" + inventory +
                '}';
    }
}
