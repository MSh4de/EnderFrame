package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.motd.MotdComponent;
import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.PacketOut;

public class PacketOutStatus extends PacketOut {

    private final MotdComponent motdComponent;

    public PacketOutStatus(MotdComponent motdComponent) {
        this.motdComponent = motdComponent;
    }

    @Override
    public void serialize(ByteMessage byteMessage) {
        byteMessage.writeValueAsString(motdComponent);
    }
}
