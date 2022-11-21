package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.inventory.ClickType;
import eu.mshade.enderframe.inventory.Inventory;
import eu.mshade.enderframe.item.ItemStack;

public class MinecraftPacketClickInventoryEvent implements MinecraftPacketEvent {

    protected Player player;
    protected Inventory inventory;
    protected ClickType clickType;
    protected ItemStack itemStack;
    protected int id, slot, key;

    public MinecraftPacketClickInventoryEvent(Player player, Inventory inventory, ClickType clickType, ItemStack itemStack, int id, int slot, int key) {
        this.player = player;
        this.inventory = inventory;
        this.clickType = clickType;
        this.itemStack = itemStack;
        this.slot = slot;
        this.key = key;
        this.id = id;
    }

    public MinecraftPacketClickInventoryEvent(Player player, Inventory inventory, ClickType clickType, ItemStack itemStack, int id, int slot) {
        this.player = player;
        this.inventory = inventory;
        this.clickType = clickType;
        this.itemStack = itemStack;
        this.slot = slot;
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public int getSlot() {
        return slot;
    }

    public int getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "PacketInventoryClickEvent{" +
                "inventory=" + inventory +
                ", clickType=" + clickType +
                ", itemStack=" + itemStack +
                ", slot=" + slot +
                ", key=" + key +
                '}';
    }
}
