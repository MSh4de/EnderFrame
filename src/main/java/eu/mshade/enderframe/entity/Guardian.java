package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class Guardian extends LivingEntity {

    /*
    protected boolean elderly;
    protected boolean retractingSpikes;
    protected int targetEntityId;

     */
    public Guardian(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.GUARDIAN);
    }

    public Guardian(Location location, int entityId) {
        super(location, entityId, EntityType.GUARDIAN);
    }



}
