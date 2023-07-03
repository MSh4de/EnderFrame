package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.InventoryKey;
import eu.mshade.enderframe.inventory.InventoryType;
import eu.mshade.enderframe.inventory.NamedInventory;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class ChestInventory extends NamedInventory {


    public ChestInventory(TextComponent textComponent, int row) {
        super(textComponent, InventoryType.CHEST, new ItemStack[(row & 6) * 9]);
    }

    public ChestInventory(TextComponent name, ItemStack[] itemStacks) {
        super(name, InventoryType.CHEST, itemStacks);
    }

    public ChestInventory(String name, int row) {
        this(TextComponent.of(name), row);
    }

}
