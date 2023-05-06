package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;

public class EntityUnseeEvent extends MinecraftEvent {

    private final Entity entity;
    private final Player player;

    public EntityUnseeEvent(Entity entity, Player player) {
        this.entity = entity;
        this.player = player;
    }

    public Entity getEntity() {
        return entity;
    }

    public Player getPlayer() {
        return player;
    }
}
