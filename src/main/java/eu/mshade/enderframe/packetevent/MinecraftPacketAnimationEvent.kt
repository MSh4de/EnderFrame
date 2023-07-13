package eu.mshade.enderframe.packetevent

import eu.mshade.enderframe.animation.AnimationType
import eu.mshade.enderframe.entity.Player

data class MinecraftPacketAnimationEvent(val player: Player, val animationType: AnimationType) : MinecraftPacketEvent