package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.UUID;

public class ChestInventory extends NamedInventory {

    protected final int row;

    public ChestInventory(TextComponent textComponent, int row) {
        super(textComponent, InventoryType.CHEST, new ItemStack[(row & 6) * 9], UUID.randomUUID());
        this.row = row;
    }

    public ChestInventory(TextComponent textComponent, int row, UUID uniqueId) {
        super(textComponent, InventoryType.CHEST, new ItemStack[(row & 6) * 9], uniqueId);
        this.row = row;
    }

    public ChestInventory(String name, int row) {
        this(TextComponent.of(name), row);
    }

    public int getRow() {
        return row;
    }
}
