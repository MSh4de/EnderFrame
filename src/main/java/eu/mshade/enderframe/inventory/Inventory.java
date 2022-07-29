package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.UniqueIdManager;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.Arrays;

public class Inventory {

    protected TextComponent textComponent;
    protected InventoryKey inventoryKey;
    protected ItemStack[] itemStacks;

    public Inventory(TextComponent textComponent, InventoryKey inventoryKey, ItemStack[] itemStacks) {
        this.textComponent = textComponent;
        this.inventoryKey = inventoryKey;
        this.itemStacks = itemStacks;
    }

    public Inventory(TextComponent textComponent, InventoryKey inventoryKey) {
        this(textComponent, inventoryKey, new ItemStack[inventoryKey.getDefaultSlot()]);
    }

    public Inventory(String name, InventoryKey inventoryKey) {
        this(TextComponent.of(name), inventoryKey);
    }

    public TextComponent getTextComponent() {
        return textComponent;
    }

    public InventoryKey getInventoryKey() {
        return inventoryKey;
    }

    public void setItemStack(int slot, ItemStack itemStack) {
        if (!itemStack.getMaterial().equals(Material.AIR)) this.itemStacks[slot] = itemStack;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                "textComponent=" + textComponent +
                ", inventoryKey=" + inventoryKey +
                '}';
    }
}
