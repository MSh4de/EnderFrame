package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.mojang.chat.TextComponent;

public class ChestInventory extends Inventory {

    protected int line;

    public ChestInventory(TextComponent textComponent, InventoryKey inventoryKey) {
        super(textComponent, inventoryKey);
    }

    public ChestInventory(String name, InventoryKey inventoryKey) {
        super(name, inventoryKey);
    }
}
