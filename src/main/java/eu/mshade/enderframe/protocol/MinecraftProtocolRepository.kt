package eu.mshade.enderframe.protocol

import org.slf4j.LoggerFactory

class MinecraftProtocolRepository {

    private val minecraftProtocolByMinecraftVersion = mutableMapOf<MinecraftProtocolVersion, MinecraftProtocol>()

    fun register(minecraftProtocol: MinecraftProtocol) {
        LOGGER.info("Register protocol {}", minecraftProtocol.minecraftProtocolVersion)
        minecraftProtocolByMinecraftVersion[minecraftProtocol.minecraftProtocolVersion] = minecraftProtocol
    }

    fun getProtocol(version: MinecraftProtocolVersion): MinecraftProtocol? {
        return minecraftProtocolByMinecraftVersion[version]
    }

    fun getProtocol(version: Int): MinecraftProtocol? {
        return getProtocol(MinecraftProtocolVersion.getProtocolVersion(version))
    }

    fun getProtocols(): MutableCollection<MinecraftProtocol> {
        return minecraftProtocolByMinecraftVersion.values
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(MinecraftProtocolRepository::class.java)
    }
}