package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Villager extends LivingEntity implements Ageable{

    /*
    protected VillagerType villagerType;

     */

    public Villager(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.VILLAGER);
    }

    public Villager(Location location, int entityId) {
        super(location, entityId, EntityType.VILLAGER);
    }


}
