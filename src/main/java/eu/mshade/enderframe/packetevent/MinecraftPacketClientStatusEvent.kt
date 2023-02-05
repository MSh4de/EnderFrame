package eu.mshade.enderframe.packetevent

import eu.mshade.enderframe.ClientStatus
import eu.mshade.enderframe.entity.Player

class MinecraftPacketClientStatusEvent(var player: Player, var clientStatus: ClientStatus): MinecraftPacketEvent {

}