package eu.mshade.enderframe.protocol.temp

import eu.mshade.enderframe.protocol.*
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutDisconnect
import eu.mshade.enderframe.protocol.temp.listener.PacketHandshakeListener
import eu.mshade.enderframe.protocol.temp.listener.PacketPingListener
import eu.mshade.enderframe.protocol.temp.listener.PacketStatusListener
import eu.mshade.enderframe.protocol.temp.packet.*
import io.netty.buffer.ByteBuf
import io.netty.channel.Channel

class TempProtocol : Protocol() {

    init {
        getEventBus().subscribe(MinecraftPacketInHandshake::class.java, PacketHandshakeListener())
        getEventBus().subscribe(MinecraftPacketInStatus::class.java, PacketStatusListener())
        getEventBus().subscribe(MinecraftPacketInPing::class.java, PacketPingListener())

        getProtocolRegistry().registerIn(MinecraftProtocolStatus.HANDSHAKE, 0x00, MinecraftPacketInHandshake::class.java)

        getProtocolRegistry().registerOut(MinecraftProtocolStatus.STATUS, 0x00, MinecraftPacketOutStatus::class.java)
        getProtocolRegistry().registerOut(MinecraftProtocolStatus.STATUS, 0x01, MinecraftPacketOutPong::class.java)
        getProtocolRegistry().registerIn(MinecraftProtocolStatus.STATUS, 0x00, MinecraftPacketInStatus::class.java)
        getProtocolRegistry().registerIn(MinecraftProtocolStatus.STATUS, 0x01, MinecraftPacketInPing::class.java)
        getProtocolRegistry().registerOut(MinecraftProtocolStatus.LOGIN, 0x00, MinecraftPacketOutDisconnect::class.java)
    }

    override fun getProtocolBuffer(byteBuf: ByteBuf): ProtocolBuffer {
        return TempProtocolBuffer(byteBuf)
    }

    override fun getSessionWrapper(channel: Channel): MinecraftSession {
        return TempMinecraftSession(channel)
    }

    override fun getMinecraftProtocolVersion(): MinecraftProtocolVersion {
        return MinecraftProtocolVersion.UNKNOWN
    }

    companion object {
        var INSTANCE = TempProtocol()
    }
}