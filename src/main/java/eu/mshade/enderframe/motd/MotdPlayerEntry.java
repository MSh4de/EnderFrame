package eu.mshade.enderframe.motd;

import java.util.UUID;

public class MotdPlayerEntry {

    private static UUID DEFAULT = UUID.randomUUID();

    private String name;
    private UUID id;

    private MotdPlayerEntry() {
    }

    public MotdPlayerEntry(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public MotdPlayerEntry(String name) {
        this(name, DEFAULT);
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MotdPlayerEntry{" +
                "name='" + name + '\'' +
                ", uuid=" + id +
                '}';
    }
}
