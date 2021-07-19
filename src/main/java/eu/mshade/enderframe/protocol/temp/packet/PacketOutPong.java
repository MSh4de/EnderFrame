package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutPong extends PacketOut {

    private final long payload;

    public PacketOutPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeLong(payload);
    }
}
