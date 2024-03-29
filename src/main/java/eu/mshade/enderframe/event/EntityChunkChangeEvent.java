package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;

public class EntityChunkChangeEvent extends EnderFrameEvent {

    private final Entity entity;

    public EntityChunkChangeEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
