package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.MinecraftPacketIn;
import eu.mshade.enderframe.protocol.ProtocolBuffer;
import eu.mshade.enderframe.protocol.SessionWrapper;

public class MinecraftPacketInPing implements MinecraftPacketIn {

    private long payload;
    private SessionWrapper sessionWrapper;

    @Override
    public void deserialize(SessionWrapper sessionWrapper, ProtocolBuffer protocolBuffer) {
        this.sessionWrapper = sessionWrapper;
        payload = protocolBuffer.readLong();
    }

    public long getPayload() {
        return payload;
    }

    @Override
    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
    }
}
