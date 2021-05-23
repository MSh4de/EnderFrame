package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketIn;

public class EnderFramePacketInPing extends PacketIn {

    private long payload;

    @Override
    public void deserialize(ByteMessage byteMessage) {
        payload = byteMessage.readLong();
    }

    public long getPayload() {
        return payload;
    }
}
