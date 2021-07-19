package eu.mshade.enderframe;

import java.util.UUID;

public class ServerListPlayerBuilder {

    private static final UUID ID = UUID.randomUUID();
    private String name;
    private UUID id;

    private ServerListPlayerBuilder(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public static ServerListPlayerBuilder of(String name){
        return new ServerListPlayerBuilder(name, ID);
    }

    public static ServerListPlayerBuilder of(String name, UUID uuid){
        return new ServerListPlayerBuilder(name, uuid);
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
