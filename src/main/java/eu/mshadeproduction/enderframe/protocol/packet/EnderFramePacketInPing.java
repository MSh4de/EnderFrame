package eu.mshadeproduction.enderframe.protocol.packet;

import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.enderframe.protocol.PacketIn;

public class EnderFramePacketInPing extends PacketIn {

    private long payload;

    @Override
    public void deserialize(ByteMessage byteMessage) {
        payload = byteMessage.readLong();
    }
}
