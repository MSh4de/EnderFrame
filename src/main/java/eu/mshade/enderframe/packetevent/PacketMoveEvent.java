package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.world.Position;

public class PacketMoveEvent implements PacketEvent {

    private Position position;
    private PacketMoveType packetMoveType;

    public PacketMoveEvent(Position position, PacketMoveType packetMoveType) {
        this.position = position;
        this.packetMoveType = packetMoveType;
    }

    public Position getPosition() {
        return position;
    }

    public PacketMoveType getPacketMoveType() {
        return packetMoveType;
    }

}
