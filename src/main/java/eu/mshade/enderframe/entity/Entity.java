package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.WorldBuffer;

import java.util.List;
import java.util.UUID;

public interface Entity {

    UUID getUUID();

    Location getLocation();

    Location getLocation(Location location);

    void setVelocity(Vector velocity);

    Vector getVelocity();

    boolean isOnGround();

    WorldBuffer getWorld();

    boolean teleport(Location location);

    boolean teleport(Location location, TeleportCause TeleportCause);

    boolean teleport(Entity destination);

    boolean teleport(Entity destination, TeleportCause teleportCause);
    
    int getEntityId();

    void remove();

    boolean isValid();

    //Server getServer();

    UUID getUniqueId();

    EntityType getType();

    void setCustomName(String name);

    String getCustomName();

    void setCustomNameVisible(boolean flag);

    boolean isCustomNameVisible();

}
