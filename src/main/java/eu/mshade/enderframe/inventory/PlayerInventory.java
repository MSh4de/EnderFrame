package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;

import java.util.function.Function;

public class PlayerInventory extends Inventory {

    public PlayerInventory() {
        super(TextComponent.of(""), InventoryType.PLAYER);
    }

    @Override
    public void setItemStack(int slot, ItemStack itemStack) {
        super.setItemStack(accurateSlot(slot), itemStack);
    }

    @Override
    public ItemStack getItemStack(int slot) {
        return super.getItemStack(accurateSlot(slot));
    }

    @Override
    public void deleteItemStack(int slot) {
        super.deleteItemStack(accurateSlot(slot));
    }

    @Override
    public int findFirstEmptySlot() {
        for (int i = 0; i < 9*4; i++) {
            ItemStack itemStack = getItemStack(i);
            if (itemStack == null) return i;
        }
        return -1;
    }

    @Override
    public int findFirstEmptySlot(int start) {
        for (int i = start; i < 9*4; i++) {
            ItemStack itemStack = getItemStack(i);
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
