package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

import java.util.function.Function;

public abstract class Inventory {

    protected InventoryKey key;
    protected ItemStack[] items;
    protected MetadataKeyValueBucket bucket;

    public Inventory(InventoryKey key, int size) {
        this.key = key;
        this.items = new ItemStack[size];
    }

    public Inventory(InventoryKey key) {
        this(key, key.getDefaultSlot());
    }

    public InventoryKey getInventoryKey() {
        return this.key;
    }

    public void setItem(int slot, ItemStack item) {
        if (item != null && !item.getMaterial().equals(Material.AIR)) {
            this.items[slot] = item;
        } else {
            this.deleteItem(slot);
        }
    }

    public void deleteItem(int slot){
        this.items[slot] = null;
    }

    public ItemStack getItem(int slot){
        return this.items[slot];
    }

    public ItemStack[] getItems() {
        return this.items;
    }

    public int findFirstEmptySlot(){
        return this.findFirstEmptySlot(0);
    }

    public int findFirstEmptySlot(int offset){
        for (int i = offset; i < this.items.length; i++) {
            final ItemStack itemStack = this.getItem(i);

            if (itemStack == null) return i;
        }
        return -1;
    }

    public ItemStack findItemStack(MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        return this.findItemStack(0, materialKey, filter);
    }

    public ItemStack findItemStack(int offset, MaterialKey materialKey, Function<ItemStack, Boolean> filter){
        for (int i = offset; i < this.items.length; i++) {
            final ItemStack itemStack = this.getItem(i);

            if (itemStack == null || !itemStack.getMaterial().equals(materialKey)) continue;

            if (filter.apply(itemStack)) {
                return itemStack;
            }
        }
        return null;
    }


    public int getSize() {
        return this.items.length;
    }

    public void fill(ItemStack[] itemStacks) {
        for (int i = 0; i < itemStacks.length; i++) {
            this.setItem(i, itemStacks[i]);
        }
    }

    public MetadataKeyValueBucket getMetadata() {
        return this.bucket;
    }
}