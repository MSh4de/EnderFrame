package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutSetCompression implements PacketOut {

    private int threshold;

    public PacketOutSetCompression(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeVarInt(threshold);
    }
}
