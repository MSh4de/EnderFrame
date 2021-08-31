package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class ServerPingEvent implements PacketEvent {

    private final Player player;
    private final long payload;

    public ServerPingEvent(Player player, long payload) {
        this.player = player;
        this.payload = payload;
    }

    public Player getPlayer() {
        return player;
    }

    public long getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "ServerPingEvent{" +
                "payload=" + payload +
                '}';
    }
}
