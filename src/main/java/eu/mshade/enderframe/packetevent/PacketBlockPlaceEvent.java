package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.block.BlockFace;

public class PacketBlockPlaceEvent implements PacketEvent {

    private Player player;
    private Vector blockPosition;
    private Vector cursorPosition;
    private BlockFace blockFace;
    private ItemStack itemStack;

    public PacketBlockPlaceEvent(Player player, Vector blockPosition, Vector cursorPosition, BlockFace blockFace, ItemStack itemStack) {
        this.player = player;
        this.blockPosition = blockPosition;
        this.cursorPosition = cursorPosition;
        this.blockFace = blockFace;
        this.itemStack = itemStack;
    }

    public Player getPlayer() {
        return player;
    }

    public Vector getBlockPosition() {
        return blockPosition;
    }

    public Vector getCursorPosition() {
        return cursorPosition;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public String toString() {
        return "PacketBlockPlaceEvent{" +
                "blockPosition=" + blockPosition +
                ", cursorPosition=" + cursorPosition +
                ", blockFace=" + blockFace +
                ", itemStack=" + itemStack +
                '}';
    }
}
