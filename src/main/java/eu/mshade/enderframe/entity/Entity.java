package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;
import eu.mshade.enderframe.world.WorldBuffer;

import java.util.List;
import java.util.Queue;
import java.util.UUID;

public interface Entity {

    Location getLocation();

    void setLocation(Location location);

    Vector getVelocity();

    void setVelocity(Vector velocity);

    int getEntityId();

    boolean isFire();

    void setFire(boolean isOnFire);

    boolean isCrounched();

    void setCrounched(boolean isCrounched);

    boolean isSprinting();

    void setSprinting(boolean isSprinting);

    boolean isEating();

    void setEating(boolean isEating);

    boolean isInvisible();

    void setInvisible(boolean isInvisible);

    short getAirTicks();

    void setAirTicks(short ticks);

    String getCustomName();

    void setCustomName(String customName);

    boolean isCustomNameVisible();

    void setCustomNameVisible(boolean isCustomNameVisible);

    boolean isSilent();

    void setSilent(boolean isSilent);

    UUID getUUID();

    EntityType getType();

    Queue<Player> getViewers();

    void addViewer(Player player);

    void removeViewer(Player player);

}
