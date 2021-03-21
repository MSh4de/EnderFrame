package eu.mshadeproduction.enderframe.protocol.packet;

import eu.mshadeproduction.enderframe.MotdBuilder;
import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.enderframe.protocol.PacketOut;

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
