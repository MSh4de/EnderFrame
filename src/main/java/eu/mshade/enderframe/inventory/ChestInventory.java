package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class ChestInventory extends Inventory {

    protected final int row;

    public ChestInventory(TextComponent textComponent, int row) {
        super(textComponent, InventoryType.CHEST, new ItemStack[row * 9]);
        this.row = row;
    }

    public ChestInventory(String name, int row) {
        super(name, InventoryType.CHEST, new ItemStack[row * 9]);
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}
