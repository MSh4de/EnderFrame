package eu.mshade.enderframe.packetevent;

public class PacketChatMessageEvent implements PacketEvent {

    private final String message;

    public PacketChatMessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
