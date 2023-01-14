package eu.mshade.enderframe.packetevent;


public interface MinecraftPacketMoveEvent extends MinecraftPacketGroundEvent {

    double getX();

    double getY();

    double getZ();

}
