package eu.mshadeproduction.enderframe.event.player;

import eu.mshadeproduction.enderframe.event.Event;
import eu.mshadeproduction.enderframe.protocol.HandshakeStatus;
import eu.mshadeproduction.enderframe.protocol.ProtocolVersion;

import java.net.InetSocketAddress;

public class HandshakeEvent extends Event {

    private ProtocolVersion version;
    private InetSocketAddress inetSocketAddress;
    private HandshakeStatus handshakeStatus;

    public HandshakeEvent(ProtocolVersion version, InetSocketAddress inetSocketAddress, HandshakeStatus handshakeStatus) {
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
        return "HandshakeEvent{" +
                "version=" + version +
                ", inetSocketAddress=" + inetSocketAddress +
                ", handshakeStatus=" + handshakeStatus +
                '}';
    }
}
