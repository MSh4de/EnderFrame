package eu.mshade.enderframe.protocol;

public interface MinecraftPacketIn {

    void deserialize(MinecraftSession minecraftSession, ProtocolBuffer protocolBuffer);

    MinecraftSession getSessionWrapper();

}
