package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;

import java.util.UUID;

public class BeaconInventory extends Inventory {

    public BeaconInventory() {
        super(InventoryType.BEACON, UUID.randomUUID());
    }

    public BeaconInventory(UUID uniqueId) {
        super(InventoryType.BEACON, uniqueId);
    }
}
