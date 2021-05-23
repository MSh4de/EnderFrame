package eu.mshadeproduction.enderframe.entity;

import eu.mshadeproduction.enderframe.world.Location;

import java.util.UUID;

public interface Entity {

    UUID getUUID();

    Location getLocation();


}
