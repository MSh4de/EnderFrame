package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.inventory.Inventory;

public class MinecraftPacketCloseInventoryEvent implements MinecraftPacketEvent {

    protected Player player;
    protected Inventory inventory;

    public MinecraftPacketCloseInventoryEvent(Player player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "PacketCloseInventoryEvent{" +
                "inventory=" + inventory +
                '}';
    }
}
