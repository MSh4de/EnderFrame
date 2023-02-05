package eu.mshade.enderframe.protocol.temp

import eu.mshade.enderframe.entity.EntityMapper
import eu.mshade.enderframe.protocol.*
import eu.mshade.enderframe.protocol.packet.MinecraftPacketOutDisconnect
import eu.mshade.enderframe.protocol.temp.listener.MinecraftPacketHandshakeListener
import eu.mshade.enderframe.protocol.temp.listener.MinecraftPacketServerPingListener
import eu.mshade.enderframe.protocol.temp.listener.MinecraftPacketServerStatusListener
import eu.mshade.enderframe.protocol.temp.packet.*
import eu.mshade.enderframe.world.block.BlockTransformerController
import io.netty.buffer.ByteBuf
import io.netty.channel.Channel

class TempMinecraftProtocol : MinecraftProtocol() {

    init {
        getEventBus().subscribe(MinecraftPacketInHandshake::class.java,
            MinecraftPacketHandshakeListener()
        )
        getEventBus().subscribe(
            MinecraftPacketInServerStatus::class.java,
            MinecraftPacketServerStatusListener()
        )
        getEventBus().subscribe(
            MinecraftPacketInServerPing::class.java,
            MinecraftPacketServerPingListener()
        )

        protocolRegistry.registerIn(MinecraftProtocolStatus.HANDSHAKE, 0x00, MinecraftPacketInHandshake::class.java)

        protocolRegistry.registerOut(MinecraftProtocolStatus.STATUS, 0x00, MinecraftPacketOutServerStatus::class.java)
        protocolRegistry.registerOut(MinecraftProtocolStatus.STATUS, 0x01, MinecraftPacketOutServerPong::class.java)
        protocolRegistry.registerIn(MinecraftProtocolStatus.STATUS, 0x00, MinecraftPacketInServerStatus::class.java)
        protocolRegistry.registerIn(MinecraftProtocolStatus.STATUS, 0x01, MinecraftPacketInServerPing::class.java)
        protocolRegistry.registerOut(MinecraftProtocolStatus.LOGIN, 0x00, MinecraftPacketOutDisconnect::class.java)
    }

    override fun getProtocolBuffer(byteBuf: ByteBuf): MinecraftByteBuf {
        return TempMinecraftByteBuf(byteBuf)
    }

    override fun getMinecraftSession(channel: Channel): MinecraftSession {
        return TempMinecraftSession(channel)
    }

    override fun getMinecraftProtocolVersion(): MinecraftProtocolVersion {
        return MinecraftProtocolVersion.UNKNOWN
    }

    override fun getBlockTransformerController(): BlockTransformerController {
        TODO("Not yet implemented")
    }

    override fun getEntityMapper(): EntityMapper {
        TODO("Not yet implemented")
    }

    companion object {
        var INSTANCE = TempMinecraftProtocol()
    }
}