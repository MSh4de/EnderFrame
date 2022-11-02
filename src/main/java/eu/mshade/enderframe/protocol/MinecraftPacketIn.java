package eu.mshade.enderframe.protocol;

public interface MinecraftPacketIn {

    void deserialize(SessionWrapper sessionWrapper, ProtocolBuffer protocolBuffer);

    SessionWrapper getSessionWrapper();

}
