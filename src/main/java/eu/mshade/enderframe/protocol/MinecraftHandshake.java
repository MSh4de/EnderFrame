package eu.mshade.enderframe.protocol;

import java.net.InetSocketAddress;

public class MinecraftHandshake {

    private MinecraftProtocolVersion version;
    private InetSocketAddress inetSocketAddress;
    private MinecraftHandshakeStatus minecraftHandshakeStatus;

    public MinecraftHandshake(MinecraftProtocolVersion version, InetSocketAddress inetSocketAddress, MinecraftHandshakeStatus minecraftHandshakeStatus) {
        this.version = version;
        this.inetSocketAddress = inetSocketAddress;
        this.minecraftHandshakeStatus = minecraftHandshakeStatus;
    }

    public MinecraftProtocolVersion getVersion() {
        return version;
    }

    public InetSocketAddress getInetSocketAddress() {
        return inetSocketAddress;
    }

    public MinecraftHandshakeStatus getHandshakeStatus() {
        return minecraftHandshakeStatus;
    }

    @Override
    public String toString() {
        return "Handshake{" +
                "version=" + version +
                ", inetSocketAddress=" + inetSocketAddress +
                ", handshakeStatus=" + minecraftHandshakeStatus +
                '}';
    }
}
