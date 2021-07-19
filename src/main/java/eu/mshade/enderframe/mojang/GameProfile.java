package eu.mshade.enderframe.mojang;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class GameProfile {

    private UUID id;
    private String name;
    private Map<String, Property> properties = new HashMap<>();

    private GameProfile() {
    }

    public GameProfile(String name) {
        this(UUID.nameUUIDFromBytes(("OfflinePlayer:"+name).getBytes(StandardCharsets.UTF_8)), name);
    }

    public GameProfile(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public GameProfile(UUID id, String name, List<Property> propertyList){
        this(id, name);
        propertyList.forEach(property -> properties.put(property.getName(), property));
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Property> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameProfile that = (GameProfile) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, properties);
    }
}
