package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;

public abstract class NonPlayerCharacter extends Player{

    public NonPlayerCharacter(Location location, Vector velocity, int entityId, UUID uuid) {
        super(location, velocity, entityId, uuid, EntityType.NO_PLAYER_CHARACTER);
    }

    public NonPlayerCharacter(Location location, int entityId) {
        super(location, entityId, EntityType.NO_PLAYER_CHARACTER);
    }
}