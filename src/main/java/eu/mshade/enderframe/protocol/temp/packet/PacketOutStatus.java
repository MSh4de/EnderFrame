package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.motd.MotdComponent;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketOutStatus implements PacketOut {

    private final MotdComponent motdComponent;

    public PacketOutStatus(MotdComponent motdComponent) {
        this.motdComponent = motdComponent;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(motdComponent);
    }
}
