package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.world.Location;

public class EntityMoveEvent implements EnderFrameEvent {

    private final Entity entity;
    private final Location location;

    public EntityMoveEvent(Entity entity, Location location) {
        this.entity = entity;
        this.location = location;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public Location getLocation() {
        return this.location;
    }
}
