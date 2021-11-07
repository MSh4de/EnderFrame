package eu.mshade.enderframe.event;

import eu.mshade.enderframe.entity.Entity;
import eu.mshade.enderframe.world.Location;

public class EntityTeleportEvent extends EnderFrameEvent {

    private final Entity entity;
    private final Location location;

    public EntityTeleportEvent(Entity entity, Location location) {
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
