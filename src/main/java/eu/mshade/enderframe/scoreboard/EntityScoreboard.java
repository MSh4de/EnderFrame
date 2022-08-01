package eu.mshade.enderframe.scoreboard;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.mojang.chat.TextComponent;

public class EntityScoreboard extends Scoreboard<Entity> {

    public EntityScoreboard(TextComponent scoreboardName) {
        super(scoreboardName);
    }
}
