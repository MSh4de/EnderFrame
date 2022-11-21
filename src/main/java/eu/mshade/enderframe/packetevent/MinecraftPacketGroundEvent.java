package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public interface MinecraftPacketGroundEvent extends MinecraftPacketEvent {

     boolean isGround();

     Player getPlayer();

}
