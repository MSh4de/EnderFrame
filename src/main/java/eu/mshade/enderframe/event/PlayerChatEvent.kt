package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player

class PlayerChatEvent(val player: Player, val message: String) : MinecraftEvent() {
}