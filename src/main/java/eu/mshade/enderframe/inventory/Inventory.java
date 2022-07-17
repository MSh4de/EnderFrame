package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.UniqueIdManager;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class Inventory {

    public static UniqueIdManager UNIQUE_ID_MANAGER = new UniqueIdManager();

    protected int id;
    protected TextComponent textComponent;
    protected InventoryKey inventoryKey;
    protected ItemStack[] itemStacks;

    public Inventory(TextComponent textComponent, InventoryKey inventoryKey) {
        this.textComponent = textComponent;
        this.inventoryKey = inventoryKey;
        this.id = UNIQUE_ID_MANAGER.getFreeId();
        this.itemStacks = new ItemStack[inventoryKey.getDefaultSlot()];
    }

    public Inventory(String name, InventoryKey inventoryKey) {
        this(TextComponent.of(name), inventoryKey);
    }

    public int getId() {
        return id;
    }

    public TextComponent getTextComponent() {
        return textComponent;
    }

    public InventoryKey getInventoryKey() {
        return inventoryKey;
    }

    public void setItemStack(int slot, ItemStack itemStack){
        if (!itemStack.getMaterial().equals(Material.AIR)) this.itemStacks[slot] = itemStack;
    }

    public ItemStack[] getItemStacks() {
        return itemStacks;
    }
}
