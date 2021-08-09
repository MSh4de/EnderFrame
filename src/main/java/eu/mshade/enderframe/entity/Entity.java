package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.Queue;
import java.util.UUID;

public abstract class Entity {

    public abstract Location getLocation();

    public abstract void setLocation(Location location);

    public abstract Vector getVelocity();

    public abstract void setVelocity(Vector velocity);

    public abstract int getEntityId();

    public abstract boolean isFire();

    public abstract void setFire(boolean isOnFire);

    public abstract boolean isSneaking();

    public abstract void setSneaking(boolean isCrounched);

    public abstract boolean isSprinting();

    public abstract void setSprinting(boolean isSprinting);

    public abstract boolean isEating();

    public abstract void setEating(boolean isEating);

    public abstract boolean isInvisible();

    public abstract void setInvisible(boolean isInvisible);

    public abstract short getAirTicks();

    public abstract void setAirTicks(short ticks);

    public abstract String getCustomName();

    public abstract void setCustomName(String customName);

    public abstract boolean isCustomNameVisible();

    public abstract void setCustomNameVisible(boolean isCustomNameVisible);

    public abstract boolean isSilent();

    public abstract void setSilent(boolean isSilent);

    public abstract UUID getUUID();

    public abstract EntityType getType();

    public abstract Queue<Player> getViewers();

    public abstract void addViewer(Player player);

    public abstract void removeViewer(Player player);

}
