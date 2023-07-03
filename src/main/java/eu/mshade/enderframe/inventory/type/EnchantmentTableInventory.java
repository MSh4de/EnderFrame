package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;

import java.util.UUID;

public class EnchantmentTableInventory extends Inventory {

    public EnchantmentTableInventory() {
        super(InventoryType.ENCHANTMENT_TABLE);
    }

    public EnchantmentTableInventory(UUID uniqueId) {
        super(InventoryType.ENCHANTMENT_TABLE);
    }
}
