package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.HandshakeStatus;
import eu.mshade.enderframe.protocol.MinecraftProtocolVersion;
import eu.mshade.enderframe.protocol.ProtocolBuffer;

public class PacketInHandshake implements PacketIn {

    private MinecraftProtocolVersion version;
    private String host;
    private int port;
    private HandshakeStatus handshakeStatus;

    @Override
    public void deserialize(ProtocolBuffer protocolBuffer) {
        this.version = MinecraftProtocolVersion.getProtocolVersion(protocolBuffer.readVarInt());
        this.host = protocolBuffer.readString();
        this.port = protocolBuffer.readUnsignedShort();
        this.handshakeStatus = HandshakeStatus.getHandShakeStatus(protocolBuffer.readVarInt());
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
