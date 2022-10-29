package eu.mshade.enderframe.protocol;

public interface PacketIn {

    void deserialize(SessionWrapper sessionWrapper, ProtocolBuffer protocolBuffer);

    SessionWrapper getSessionWrapper();

}
