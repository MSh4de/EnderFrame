package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.mojang.chat.TextComponent;

public class ChestInventory extends Inventory {

    protected int line;

    public ChestInventory(TextComponent textComponent) {
        super(textComponent, InventoryType.CHEST);
    }

    public ChestInventory(String name) {
        super(name, InventoryType.CHEST);
    }
}
