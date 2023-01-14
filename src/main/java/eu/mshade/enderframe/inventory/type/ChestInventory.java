package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.InventoryType;
import eu.mshade.enderframe.inventory.NamedInventory;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import java.util.UUID;

public class ChestInventory extends NamedInventory {



    public ChestInventory(TextComponent textComponent, int row) {
        super(textComponent, InventoryType.CHEST, new ItemStack[(row & 6) * 9], UUID.randomUUID());
    }

    public ChestInventory(TextComponent textComponent, int row, UUID uniqueId) {
        super(textComponent, InventoryType.CHEST, new ItemStack[(row & 6) * 9], uniqueId);
    }

    public ChestInventory(String name, int row) {
        this(TextComponent.of(name), row);
    }

}
