package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;

import java.util.UUID;

public class BrewingStandInventory extends Inventory {

    public BrewingStandInventory() {
        super(InventoryType.BREWING_STAND);
    }

    public BrewingStandInventory(UUID uniqueId) {
        super(InventoryType.BREWING_STAND);
    }
}
