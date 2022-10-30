package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Zombie extends LivingEntity implements Ageable {

    public Zombie(Location location, Vector velocity, int entityId, UUID uuid, EntityType entityType) {
        super(location, velocity, entityId, uuid, entityType);
    }

    public Zombie(Location location, int entityId, EntityType entityType) {
        super(location, entityId, entityType);
    }

    public Zombie(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.ZOMBIE);
    }

    public Zombie(Location location, int entityId) {
        super(location, entityId, EntityType.ZOMBIE);
    }

    /*
    protected boolean isVillager;
    protected boolean isConverting;

     */


}
