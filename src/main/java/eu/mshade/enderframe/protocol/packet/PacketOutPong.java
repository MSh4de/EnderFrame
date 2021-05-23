package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class EnderFramePacketOutPong extends PacketOut {

    private final long payload;

    public EnderFramePacketOutPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeLong(payload);
    }
}
