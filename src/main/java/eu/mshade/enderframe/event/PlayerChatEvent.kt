package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player

data class PlayerChatEvent(val player: Player, val message: String) : MinecraftEvent()
