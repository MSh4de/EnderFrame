package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.entity.Player;

public class EntitySeeEvent extends EnderFrameEvent {

    private final Entity entity;
    private final Player player;

    public EntitySeeEvent(Entity entity, Player player) {
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
