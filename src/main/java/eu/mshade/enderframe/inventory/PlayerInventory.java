package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.Agent;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

public class PlayerInventory extends Inventory {

    public PlayerInventory(UUID uniqueId) {
        super(InventoryType.PLAYER, uniqueId);
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
        return findFirstEmptySlot(0);
    }

    @Override
    public int findFirstEmptySlot(int offset) {
        for (int i = offset; i < 9*4; i++) {
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

    public static int indexFromAccurateSlot(int accurateSlot) {
        if (accurateSlot <= 44 && accurateSlot >= 36) {
            return 8 - (44 - accurateSlot);
        } else if (accurateSlot <= 8) {
            return 44 - accurateSlot;
        }
        return accurateSlot;
    }

}
