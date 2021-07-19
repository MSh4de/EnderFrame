package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;

import java.util.UUID;

public interface Entity {

    UUID getUUID();

    Location getLocation();


}
