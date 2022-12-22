package eu.mshade.enderframe.protocol

interface MinecraftPacketIn {

    fun deserialize(minecraftSession: MinecraftSession, minecraftByteBuf: MinecraftByteBuf)

    fun getMinecraftSession(): MinecraftSession
}