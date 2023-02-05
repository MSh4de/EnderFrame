package eu.mshade.enderframe.protocol.temp.packet;

import eu.mshade.enderframe.protocol.*;

public class MinecraftPacketInHandshake implements MinecraftPacketIn {

    private MinecraftSession minecraftSession;
    private MinecraftProtocolVersion version;
    private String host;
    private int port;
    private MinecraftHandshakeStatus minecraftHandshakeStatus;

    @Override
    public void deserialize(MinecraftSession minecraftSession, MinecraftByteBuf minecraftByteBuf) {
        this.minecraftSession = minecraftSession;
        this.version = MinecraftProtocolVersion.getProtocolVersion(minecraftByteBuf.readVarInt());
        this.host = minecraftByteBuf.readString();
        this.port = minecraftByteBuf.readUnsignedShort();
        this.minecraftHandshakeStatus = MinecraftHandshakeStatus.getHandShakeStatus(minecraftByteBuf.readVarInt());
    }

    @Override
    public MinecraftSession getMinecraftSession() {
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

    public MinecraftHandshakeStatus getHandshakeStatus() {
        return minecraftHandshakeStatus;
    }
}
