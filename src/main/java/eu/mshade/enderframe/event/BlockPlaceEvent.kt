package eu.mshade.enderframe.event

import eu.mshade.enderframe.entity.Player
import eu.mshade.enderframe.world.Vector
import eu.mshade.enderframe.world.block.Block

data class BlockPlaceEvent(val player: Player, val block: Block, val position: Vector) : MinecraftEvent()