package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;

import java.util.UUID;

public class AnvilInventory extends Inventory {

    public AnvilInventory() {
        super(InventoryType.ANVIL);
    }

    public AnvilInventory(UUID uniqueId) {
        super(InventoryType.ANVIL);
    }
}
