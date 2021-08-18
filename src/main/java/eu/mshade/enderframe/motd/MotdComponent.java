package eu.mshade.enderframe.motd;

import eu.mshade.enderframe.mojang.chat.TextComponent;

public class MotdComponent {

    private MotdVersion version;
    private MotdPlayer players;
    private TextComponent description;
    private String favicon;

    private MotdComponent() {
    }

    public MotdComponent(MotdVersion version, MotdPlayer players, TextComponent description) {
        this(version, players, description, null);
    }

    public MotdComponent(MotdVersion version, MotdPlayer players, TextComponent description, String favicon) {
        this.version = version;
        this.players = players;
        this.description = description;
        this.favicon = favicon;
    }

    public MotdVersion getVersion() {
        return version;
    }

    public MotdPlayer getPlayers() {
        return players;
    }

    public TextComponent getDescription() {
        return description;
    }


    public String getFavicon() {
        return favicon;
    }


    public MotdComponent setVersion(MotdVersion version) {
        this.version = version;
        return this;
    }

    public MotdComponent setPlayers(MotdPlayer players) {
        this.players = players;
        return this;
    }

    public MotdComponent setDescription(TextComponent description) {
        this.description = description;
        return this;
    }

    public MotdComponent setFavicon(String favicon) {
        this.favicon = favicon;
        return this;
    }

    @Override
    public String toString() {
        return "MotdComponent{" +
                "version=" + version +
                ", players=" + players +
                ", description=" + description +
                '}';
    }
}
