package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Arrow extends Entity {

    private boolean isCritical;

    public Arrow(Location location, Vector velocity, int entityId, boolean isCritical) {
        super(location, velocity, entityId, false, false, false, false, false, (short) 0, "", false, false, UUID.randomUUID(), EntityType.ARROW, null);
        this.isCritical = isCritical;
    }

    public Arrow(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, boolean isCritical) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.ARROW, new ConcurrentLinkedQueue<>());
        this.isCritical = isCritical;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean isCritical) {
        this.isCritical = isCritical;
    }
}
