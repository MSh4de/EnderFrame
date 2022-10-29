package eu.mshade.enderframe.protocol.temp

import eu.mshade.enderframe.protocol.*
import eu.mshade.enderframe.protocol.packet.PacketOutDisconnect
import eu.mshade.enderframe.protocol.temp.listener.PacketHandshakeListener
import eu.mshade.enderframe.protocol.temp.listener.PacketPingListener
import eu.mshade.enderframe.protocol.temp.listener.PacketStatusListener
import eu.mshade.enderframe.protocol.temp.packet.*
import io.netty.buffer.ByteBuf
import io.netty.channel.Channel

class TempProtocol : Protocol() {

    init {
        getEventBus().subscribe(PacketInHandshake::class.java, PacketHandshakeListener())
        getEventBus().subscribe(PacketInStatus::class.java, PacketStatusListener())
        getEventBus().subscribe(PacketInPing::class.java, PacketPingListener())

        getProtocolRegistry().registerIn(ProtocolStatus.HANDSHAKE, 0x00, PacketInHandshake::class.java)

        getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x00, PacketOutStatus::class.java)
        getProtocolRegistry().registerOut(ProtocolStatus.STATUS, 0x01, PacketOutPong::class.java)
        getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x00, PacketInStatus::class.java)
        getProtocolRegistry().registerIn(ProtocolStatus.STATUS, 0x01, PacketInPing::class.java)
        getProtocolRegistry().registerOut(ProtocolStatus.LOGIN, 0x00, PacketOutDisconnect::class.java)
    }

    override fun getProtocolBuffer(byteBuf: ByteBuf): ProtocolBuffer {
        return TempProtocolBuffer(byteBuf)
    }

    override fun getSessionWrapper(channel: Channel): SessionWrapper {
        return TempSessionWrapper(channel)
    }

    override fun getMinecraftProtocolVersion(): MinecraftProtocolVersion {
        return MinecraftProtocolVersion.UNKNOWN
    }

    companion object {
        var INSTANCE = TempProtocol()
    }
}