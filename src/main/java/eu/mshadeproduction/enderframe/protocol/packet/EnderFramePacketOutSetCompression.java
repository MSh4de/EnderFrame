package eu.mshadeproduction.enderframe.protocol.packet;

import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.enderframe.protocol.PacketOut;

public class EnderFramePacketOutSetCompression extends PacketOut {

    private final int size;

    public EnderFramePacketOutSetCompression(int size) {
        this.size = size;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeVarInt(size);
    }
}
