package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.world.Vector;

public class PacketOutSpawnPosition implements PacketOut {

    private Vector blockPosition;

    public PacketOutSpawnPosition(Vector blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeBlockPosition(blockPosition);
    }
}
