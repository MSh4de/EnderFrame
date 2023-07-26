package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player

class PlayerTabCompleteEvent(val player: Player, val text: String, val currentIndex: Int, val args: Array<String>) : MinecraftEvent() {
}