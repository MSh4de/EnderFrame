package eu.mshade.enderframe.inventory;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class PlayerInventory extends Inventory {

    public PlayerInventory() {
        super(TextComponent.of(""), InventoryType.PLAYER);
    }

    @Override
    public void setItemStack(int slot, ItemStack itemStack) {
        super.setItemStack(accurateSlot(slot), itemStack);
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
