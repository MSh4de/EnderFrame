package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InventoryBufferStore {

    protected ItemStack pickedItemStack;
    protected int pickedSlot = 0;
    protected ClickType lastClickType = ClickType.UNKNOWN;
    protected List<PlacedItemStack> placedItemStacks = new ArrayList<>();

    public ItemStack getPickedItemStack() {
        return pickedItemStack;
    }

    public void setPickedItemStack(ItemStack pickedItemStack) {
        this.pickedItemStack = pickedItemStack;
    }

    public int getPickedSlot() {
        return pickedSlot;
    }

    public void setPickedSlot(int pickedSlot) {
        this.pickedSlot = pickedSlot;
    }

    public ClickType getLastClickType() {
        return lastClickType;
    }

    public void setLastClickType(ClickType lastClickType) {
        this.lastClickType = lastClickType;
    }

    public void addPlacedItemStack(int slot, boolean playerInventory){
        this.placedItemStacks.add(new PlacedItemStack(slot, playerInventory));
    }

    public Collection<PlacedItemStack> getPLacedItemStacks(){
        return this.placedItemStacks;
    }

    public void clearPLacedItemStacks(){
        this.placedItemStacks.clear();;
    }

    public static class PlacedItemStack {

        protected int slot;
        protected boolean playerInventory;

        public PlacedItemStack(int slot, boolean playerInventory) {
            this.slot = slot;
            this.playerInventory = playerInventory;
        }

        public PlacedItemStack(int slot) {
            this.slot = slot;
        }

        public int getSlot() {
            return slot;
        }

        public boolean isPlayerInventory() {
            return playerInventory;
        }
    }

}
