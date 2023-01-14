package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player

data class PlayerJoinEvent(val player: Player) : EnderFrameEvent()