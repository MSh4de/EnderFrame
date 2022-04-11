package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.ByteMessage;
import eu.mshade.enderframe.protocol.HandshakeStatus;
import eu.mshade.enderframe.protocol.PacketIn;
import eu.mshade.enderframe.protocol.MinecraftProtocolVersion;

public class PacketInHandshake extends PacketIn {

    private MinecraftProtocolVersion version;
    private String host;
    private int port;
    private HandshakeStatus handshakeStatus;

    @Override
    public void deserialize(ByteMessage byteMessage) {
        this.version = MinecraftProtocolVersion.getProtocolVersion(byteMessage.readVarInt());
        this.host = byteMessage.readString();
        this.port = byteMessage.readUnsignedShort();
        this.handshakeStatus = HandshakeStatus.getHandShakeStatus(byteMessage.readVarInt());
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
