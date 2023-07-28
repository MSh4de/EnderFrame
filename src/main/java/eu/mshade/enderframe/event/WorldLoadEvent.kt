package eu.mshade.enderframe.event

import eu.mshade.enderframe.world.World

data class WorldLoadEvent(val world: World) : MinecraftEvent()
