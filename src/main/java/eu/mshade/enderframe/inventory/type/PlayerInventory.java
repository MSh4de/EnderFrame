package eu.mshade.enderframe.inventory.type;

import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.inventory.InventoryType;
import eu.mshade.enderframe.item.ItemStack;

public class PlayerInventory extends Inventory {

    public PlayerInventory() {
        super(InventoryType.PLAYER);
    }

    @Override
    public void setItem(int slot, ItemStack itemStack) {
        super.setItem(accurateSlot(slot), itemStack);
    }

    @Override
    public ItemStack getItem(int slot) {
        return super.getItem(accurateSlot(slot));
    }

    @Override
    public void deleteItem(int slot) {
        super.deleteItem(accurateSlot(slot));
    }

    @Override
    public int findFirstEmptySlot() {
        return findFirstEmptySlot(0);
    }

    @Override
    public int findFirstEmptySlot(int offset) {
        for (int i = offset; i < 9*4; i++) {
            ItemStack itemStack = this.getItem(i);
            if (itemStack == null) return i;
        }
        return -1;
    }


    public static int accurateSlot(int index) {
        if (index <= 8) {
            return index + 36;
        } else if (index >= 36 && index <= 44) {
            return 44 - index;
        }
        return index;
    }

}