package eu.mshade.enderframe.packetevent;

import eu.mshade.enderframe.entity.Player;

public class MinecraftPacketChatMessageEvent implements MinecraftPacketEvent {

    private Player player;
    private final String message;

    public MinecraftPacketChatMessageEvent(Player player, String message) {
        this.player = player;
        this.message = message;
    }

    public Player getPlayer() {
        return player;
    }

    public String getMessage() {
        return message;
    }



}
