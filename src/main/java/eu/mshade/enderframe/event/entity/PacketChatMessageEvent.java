package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;

public class PacketChatMessageEvent implements PacketEvent {

    private final String message;

    public PacketChatMessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
