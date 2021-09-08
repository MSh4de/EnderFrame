package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.event.EnderFrameEvent;

public class EntityUnseeEvent extends EnderFrameEvent {

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
