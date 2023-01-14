package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketInPing implements PacketIn {

    private long payload;

    @Override
    public void deserialize(ProtocolBuffer protocolBuffer) {
        payload = protocolBuffer.readLong();
    }

    public long getPayload() {
        return payload;
    }
}
