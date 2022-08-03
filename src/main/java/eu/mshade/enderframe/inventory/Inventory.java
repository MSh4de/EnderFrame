package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.UniqueIdManager;
import eu.mshade.enderframe.entity.Item;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.Arrays;
import java.util.function.Function;

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
        if (itemStack != null && !itemStack.getMaterial().equals(Material.AIR)) this.itemStacks[slot] = itemStack;
        else this.itemStacks[slot] = null;
    }

    public void deleteItemStack(int slot){
        this.itemStacks[slot] = null;
    }

    public ItemStack getItemStack(int slot){
        return this.itemStacks[slot];
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }

    public int findFirstEmptySlot(){
        for (int i = 0; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null) return i;
        }
        return -1;
    }

    public int findFirstEmptySlot(int start){
        for (int i = start; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null) return i;
        }
        return -1;
    }

    public ItemStack findItemStack(MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        for (int i = 0; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null || !itemStack.getMaterial().equals(materialKey)) continue;
            if (filter.apply(itemStack)) {
                return itemStack;
            }
        }
        return null;
    }



    @Override
    public String toString() {
        return "Inventory{" +
                "textComponent=" + textComponent +
                ", inventoryKey=" + inventoryKey +
                '}';
    }
}
