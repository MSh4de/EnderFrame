package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutSetCompression extends PacketOut {

    private int threshold;

    public PacketOutSetCompression(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeVarInt(threshold);
    }
}
