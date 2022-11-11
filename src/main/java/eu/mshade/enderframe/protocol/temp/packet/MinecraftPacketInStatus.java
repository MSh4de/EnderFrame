package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketIn;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.protocol.MinecraftSession;

public class MinecraftPacketInStatus implements MinecraftPacketIn {

    private MinecraftSession minecraftSession;

    @Override
    public void deserialize(MinecraftSession minecraftSession, ProtocolBuffer protocolBuffer) {
        this.minecraftSession = minecraftSession;
    }

    @Override
    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }
}
