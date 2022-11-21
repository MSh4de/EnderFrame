package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.UUID;
import java.util.function.Function;

public abstract class Inventory {

    protected InventoryKey inventoryKey;
    protected ItemStack[] itemStacks;

    public Inventory(InventoryKey inventoryKey, ItemStack[] itemStacks) {
        this.inventoryKey = inventoryKey;
        this.itemStacks = itemStacks;
    }

    public Inventory(InventoryKey inventoryKey) {
        this(inventoryKey, new ItemStack[inventoryKey.getDefaultSlot()]);
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
        return findFirstEmptySlot(0);
    }

    public int findFirstEmptySlot(int offset){
        for (int i = offset; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null) return i;
        }
        return -1;
    }

    public ItemStack findItemStack(MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        return findItemStack(0, materialKey, filter);
    }

    public ItemStack findItemStack(int offset, MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        for (int i = offset; i < itemStacks.length; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null || !itemStack.getMaterial().equals(materialKey)) continue;
            if (filter.apply(itemStack)) {
                return itemStack;
            }
        }
        return null;
    }


    public int getSize() {
        return itemStacks.length;
    }

    public void fill(ItemStack[] itemStacks) {
        for (int i = 0; i < itemStacks.length; i++) {
            setItemStack(i, itemStacks[i]);
        }
    }


}
