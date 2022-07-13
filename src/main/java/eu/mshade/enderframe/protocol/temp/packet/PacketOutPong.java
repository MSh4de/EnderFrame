package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.PacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutPong implements PacketOut {

    private final long payload;

    public PacketOutPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeLong(payload);
    }
}
