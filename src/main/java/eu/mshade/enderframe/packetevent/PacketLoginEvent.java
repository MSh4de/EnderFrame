package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class PacketLoginEvent implements PacketEvent {

    private final Player player;
    private final String name;

    public PacketLoginEvent(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String getName() {
        return name;
    }
}
