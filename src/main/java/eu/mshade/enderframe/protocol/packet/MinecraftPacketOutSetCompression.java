package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class MinecraftPacketOutSetCompression implements MinecraftPacketOut {

    private int threshold;

    public MinecraftPacketOutSetCompression(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeVarInt(threshold);
    }
}
