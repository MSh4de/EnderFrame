package eu.mshade.enderframe.packetevent;

public class PacketLoginEvent implements PacketEvent {

    private String name;

    public PacketLoginEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
