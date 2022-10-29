package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.*;

public class PacketInHandshake implements PacketIn {

    private SessionWrapper sessionWrapper;
    private MinecraftProtocolVersion version;
    private String host;
    private int port;
    private HandshakeStatus handshakeStatus;

    @Override
    public void deserialize(SessionWrapper sessionWrapper, ProtocolBuffer protocolBuffer) {
        this.sessionWrapper = sessionWrapper;
        this.version = MinecraftProtocolVersion.getProtocolVersion(protocolBuffer.readVarInt());
        this.host = protocolBuffer.readString();
        this.port = protocolBuffer.readUnsignedShort();
        this.handshakeStatus = HandshakeStatus.getHandShakeStatus(protocolBuffer.readVarInt());
    }

    @Override
    public SessionWrapper getSessionWrapper() {
        return sessionWrapper;
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
