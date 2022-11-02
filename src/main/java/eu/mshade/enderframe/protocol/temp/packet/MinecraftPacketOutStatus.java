package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.motd.MotdComponent;
import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class MinecraftPacketOutStatus implements MinecraftPacketOut {

    private final MotdComponent motdComponent;

    public MinecraftPacketOutStatus(MotdComponent motdComponent) {
        this.motdComponent = motdComponent;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeValueAsString(motdComponent);
    }
}
