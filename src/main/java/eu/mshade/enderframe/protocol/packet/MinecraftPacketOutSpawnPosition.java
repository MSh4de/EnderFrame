package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.world.Vector;

public class MinecraftPacketOutSpawnPosition implements MinecraftPacketOut {

    private Vector blockPosition;

    public MinecraftPacketOutSpawnPosition(Vector blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeBlockPosition(blockPosition);
    }
}
