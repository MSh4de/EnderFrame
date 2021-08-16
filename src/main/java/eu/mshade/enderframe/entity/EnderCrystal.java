package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class EnderCrystal extends Entity {

    private int health;

    public EnderCrystal(Location location, Vector velocity, int entityId, boolean isFire, boolean isSneaking, boolean isSprinting, boolean isEating, boolean isInvisible, short airTicks, String customName, boolean isCustomNameVisible, boolean isSilent, UUID uuid, int health) {
        super(location, velocity, entityId, isFire, isSneaking, isSprinting, isEating, isInvisible, airTicks, customName, isCustomNameVisible, isSilent, uuid, EntityType.END_CRYSTAL);
        this.health = health;
    }

    public EnderCrystal(Location location, int entityId, int health) {
        super(location, EntityType.END_CRYSTAL, entityId);
        this.health = health;
    }

    public EnderCrystal(Location location, int entityId) {
        this(location, entityId, 20);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
