package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.item.ItemStack;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.block.BlockFace;

public class PacketBlockPlaceEvent implements PacketEvent {

    private Vector blockPosition;
    private BlockFace blockFace;
    private ItemStack itemStack;

    public PacketBlockPlaceEvent(Vector blockPosition, BlockFace blockFace, ItemStack itemStack) {
        this.blockPosition = blockPosition;
        this.blockFace = blockFace;
        this.itemStack = itemStack;
    }

    public Vector getBlockPosition() {
        return blockPosition;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
