package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.block.BlockFace;
import eu.mshade.enderframe.world.block.DiggingStatus;

public class PacketPlayerDiggingEvent implements PacketEvent{

    private Player player;
    private Vector blockPosition;
    private BlockFace blockFace;
    private DiggingStatus diggingStatus;

    public PacketPlayerDiggingEvent(Player player, Vector blockPosition, BlockFace blockFace, DiggingStatus diggingStatus) {
        this.player = player;
        this.blockPosition = blockPosition;
        this.blockFace = blockFace;
        this.diggingStatus = diggingStatus;
    }

    public Player getPlayer() {
        return player;
    }

    public Vector getBlockPosition() {
        return blockPosition;
    }

    public BlockFace getBlockFace() {
        return blockFace;
    }

    public DiggingStatus getDiggingStatus() {
        return diggingStatus;
    }

    @Override
    public String toString() {
        return "PacketPlayerDiggingEvent{" +
                "blockPosition=" + blockPosition +
                ", blockFace=" + blockFace +
                ", diggingStatus=" + diggingStatus +
                '}';
    }
}
