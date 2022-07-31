package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;

public class InventoryBufferStore {

    protected ItemStack pickedItemStack;
    protected ClickType lastClickType = ClickType.UNKNOWN;

    public ItemStack getPickedItemStack() {
        return pickedItemStack;
    }

    public void setPickedItemStack(ItemStack pickedItemStack) {
        this.pickedItemStack = pickedItemStack;
    }

    public ClickType getLastClickType() {
        return lastClickType;
    }

    public void setLastClickType(ClickType lastClickType) {
        this.lastClickType = lastClickType;
    }
}
