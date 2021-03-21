package eu.mshadeproduction.enderframe.protocol.packet;

import eu.mshadeproduction.enderframe.protocol.ByteMessage;
import eu.mshadeproduction.enderframe.protocol.HandshakeStatus;
import eu.mshadeproduction.enderframe.protocol.PacketIn;
import eu.mshadeproduction.enderframe.protocol.ProtocolVersion;

public class EnderFramePacketInHandshake extends PacketIn {

    private ProtocolVersion version;
    private String host;
    private int port;
    private HandshakeStatus handshakeStatus;

    @Override
    public void deserialize(ByteMessage byteMessage) {
        this.version = ProtocolVersion.getProtocolVersion(byteMessage.readVarInt());
        this.host = byteMessage.readString();
        this.port = byteMessage.readUnsignedShort();
        this.handshakeStatus = HandshakeStatus.getHandShakeStatus(byteMessage.readVarInt());
    }

    public ProtocolVersion getVersion() {
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
