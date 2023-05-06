package eu.mshade.enderframe.packetevent

import eu.mshade.enderframe.entity.Player

class MinecraftPacketHeldItemChangeEvent(val player: Player, val slot: Int) : MinecraftPacketEvent