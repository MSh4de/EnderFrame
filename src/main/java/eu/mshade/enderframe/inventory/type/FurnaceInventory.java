package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;

import java.util.UUID;

public class FurnaceInventory extends Inventory {

    public FurnaceInventory() {
        super(InventoryType.FURNACE, UUID.randomUUID());
    }

    public FurnaceInventory(UUID uniqueId) {
        super(InventoryType.FURNACE, uniqueId);
    }
}
