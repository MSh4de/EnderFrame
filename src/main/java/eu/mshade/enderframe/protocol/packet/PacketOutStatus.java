package eu.mshade.enderframe.protocol.packet;

import eu.mshade.enderframe.MotdBuilder;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class EnderFramePacketOutStatus extends PacketOut {

    private final MotdBuilder motdBuilder;

    public EnderFramePacketOutStatus(MotdBuilder motdBuilder) {
        this.motdBuilder = motdBuilder;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeString(motdBuilder.build());
    }
}
