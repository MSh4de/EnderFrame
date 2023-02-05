package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.world.Location

data class PlayerMoveEvent(val player: Player, val from: Location, val to: Location) : EnderFrameEvent()