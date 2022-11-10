package eu.mshade.enderframe.protocol

import org.slf4j.LoggerFactory

class ProtocolRepository {

    private val protocolByMinecraftVersion = mutableMapOf<MinecraftProtocolVersion, Protocol>()

    fun register(protocol: Protocol) {
        LOGGER.info("Register protocol {}", protocol.minecraftProtocolVersion)
        protocolByMinecraftVersion[protocol.minecraftProtocolVersion] = protocol
    }

    fun getProtocol(version: MinecraftProtocolVersion): Protocol? {
        return protocolByMinecraftVersion[version]
    }

    fun getProtocol(version: Int): Protocol? {
        return getProtocol(MinecraftProtocolVersion.getProtocolVersion(version))
    }

    fun getProtocols(): MutableCollection<Protocol> {
        return protocolByMinecraftVersion.values
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ProtocolRepository::class.java)
    }
}