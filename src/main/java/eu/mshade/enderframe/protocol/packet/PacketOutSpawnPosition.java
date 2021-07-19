package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.world.BlockPosition;

public class PacketOutSpawnPosition extends PacketOut {

    private BlockPosition blockPosition;

    public PacketOutSpawnPosition(BlockPosition blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeBlockPosition(blockPosition);
    }
}
