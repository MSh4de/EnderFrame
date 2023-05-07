package eu.mshade.enderframe.event

import eu.mshade.enderframe.protocol.MinecraftSession

data class PlayerDisconnectEvent(val minecraftSession: MinecraftSession) : MinecraftEvent()