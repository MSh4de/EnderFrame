package eu.mshade.enderframe.packetevent

import eu.mshade.enderframe.protocol.MinecraftSession

class MinecraftPacketTabCompleteEvent(val minecraftSession: MinecraftSession, val text: String): MinecraftPacketEvent {


}