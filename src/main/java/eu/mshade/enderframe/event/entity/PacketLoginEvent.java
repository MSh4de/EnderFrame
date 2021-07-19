package eu.mshade.enderframe.event.entity;

import eu.mshade.enderframe.event.PacketEvent;

public class PacketLoginEvent implements PacketEvent {

    private String name;

    public PacketLoginEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
