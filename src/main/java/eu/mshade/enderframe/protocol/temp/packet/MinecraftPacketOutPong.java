package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketOut;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class MinecraftPacketOutPong implements MinecraftPacketOut {

    private final long payload;

    public MinecraftPacketOutPong(long payload) {
        this.payload = payload;
    }

    @Override
    public void serialize(ProtocolBuffer protocolBuffer) {
        protocolBuffer.writeLong(payload);
    }
}
