package eu.mshadeproduction.enderframe.protocol.packet;

import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.enderframe.protocol.PacketOut;

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
