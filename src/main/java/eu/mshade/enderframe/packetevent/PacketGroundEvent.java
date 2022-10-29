package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public interface PacketGroundEvent extends PacketEvent{

     boolean isGround();

     Player getPlayer();

}
