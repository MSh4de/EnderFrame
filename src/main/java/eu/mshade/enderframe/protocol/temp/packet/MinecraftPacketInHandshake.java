package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.*;

public class MinecraftPacketInHandshake implements MinecraftPacketIn {

    private MinecraftSession minecraftSession;
    private MinecraftProtocolVersion version;
    private String host;
    private int port;
    private HandshakeStatus handshakeStatus;

    @Override
    public void deserialize(MinecraftSession minecraftSession, ProtocolBuffer protocolBuffer) {
        this.minecraftSession = minecraftSession;
        this.version = MinecraftProtocolVersion.getProtocolVersion(protocolBuffer.readVarInt());
        this.host = protocolBuffer.readString();
        this.port = protocolBuffer.readUnsignedShort();
        this.handshakeStatus = HandshakeStatus.getHandShakeStatus(protocolBuffer.readVarInt());
    }

    @Override
    public MinecraftSession getSessionWrapper() {
        return minecraftSession;
    }

    public MinecraftProtocolVersion getVersion() {
        return version;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public HandshakeStatus getHandshakeStatus() {
        return handshakeStatus;
    }
}
