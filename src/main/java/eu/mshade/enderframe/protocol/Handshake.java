package eu.mshade.enderframe.protocol;

import java.net.InetSocketAddress;

public class Handshake {

    private ProtocolVersion version;
    private InetSocketAddress inetSocketAddress;
    private HandshakeStatus handshakeStatus;

    public Handshake(ProtocolVersion version, InetSocketAddress inetSocketAddress, HandshakeStatus handshakeStatus) {
        this.version = version;
        this.inetSocketAddress = inetSocketAddress;
        this.handshakeStatus = handshakeStatus;
    }

    public ProtocolVersion getVersion() {
        return version;
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public HandshakeStatus getHandshakeStatus() {
        return handshakeStatus;
    }

    @Override
    public String toString() {
        return "Handshake{" +
                "version=" + version +
                ", inetSocketAddress=" + inetSocketAddress +
                ", handshakeStatus=" + handshakeStatus +
                '}';
    }
}
