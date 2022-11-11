package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketIn;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketInPing implements MinecraftPacketIn {

    private long payload;
    private MinecraftSession minecraftSession;

    @Override
    public void deserialize(MinecraftSession minecraftSession, ProtocolBuffer protocolBuffer) {
        this.minecraftSession = minecraftSession;
        payload = protocolBuffer.readLong();
    }

    public long getPayload() {
        return payload;
    }

    @Override
    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
