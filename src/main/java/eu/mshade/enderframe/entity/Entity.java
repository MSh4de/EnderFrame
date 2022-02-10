package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.EnderFrameSession;
import eu.mshade.enderframe.EnderFrameSessionHandler;
import eu.mshade.enderframe.event.*;
import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.*;

public interface Entity {

    /**
    protected Location beforeLocation;
    protected Location location;
    private Vector velocity;
    private final int entityId;
    private boolean isFire;
    private boolean isSneaking;
    private boolean isSprinting;
    private boolean isEating;
    private boolean isInvisible;
    private short airTicks;
    private String customName;
    private boolean isCustomNameVisible;
    private boolean isSilent;
    protected UUID uuid;
    private final EntityType entityType;
     **/



    Location getBeforeLocation();

    Location getLocation();

    /*
    public void teleport(Location location) {
        EntityTeleportEvent entityTeleportEvent = new EntityTeleportEvent(this, location);
        EnderFrame.get().getEnderFrameEventBus().publish(entityTeleportEvent);

        if (!entityTeleportEvent.isCancelled()) {
            this.setUnsafeLocation(this.getLocation());
            this.getViewers()
                    .stream()
                    .map(Player::getEnderFrameSessionHandler)
                    .map(EnderFrameSessionHandler::getEnderFrameSession)
                    .forEach(session -> session.sendTeleport(this));

            if (!this.getBeforeLocation().getChunkBuffer().equals(this.getLocation().getChunkBuffer()))
                sendEntityChunkChange();
        }
    }



    public void move(Location location) {
        EntityMoveEvent entityMoveEvent = new EntityMoveEvent(this, location);
        EnderFrame.get().getEnderFrameEventBus().publish(entityMoveEvent);

        if (!entityMoveEvent.isCancelled()) {
            this.setUnsafeLocation(location.clone());
            System.out.println(this.getViewers());
            System.out.println(this.getLocation());
            this.getViewers()
                    .stream()
                    .map(Player::getEnderFrameSessionHandler)
                    .map(EnderFrameSessionHandler::getEnderFrameSession)
                    .forEach(session -> session.moveTo(this));

            if (!this.getBeforeLocation().getChunkBuffer().equals(this.getLocation().getChunkBuffer()))
                sendEntityChunkChange();
        }
    }

    private void sendEntityChunkChange() {
        EntityChunkChangeEvent entityChunkChangeEvent = new EntityChunkChangeEvent(this);
        EnderFrame.get().getEnderFrameEventBus().publish(entityChunkChangeEvent);

        if (!entityChunkChangeEvent.isCancelled()) {
            this.getBeforeLocation().getChunkBuffer().removeEntity(this);
            this.getLocation().getChunkBuffer().addEntity(this);
        }
    }

     */


    Vector getVelocity();

    void setVelocity(Vector velocity);

    int getEntityId();

    boolean isFire();

    void setFire(boolean fire);

    boolean isSneaking();

    void setSneaking(boolean sneaking);

     boolean isSprinting();

     void setSprinting(boolean sprinting);

     boolean isEating();

     void setEating(boolean eating);

     boolean isInvisible();

     void setInvisible(boolean invisible);

     short getAirTicks();

    void setAirTicks(short airTicks);

    String getCustomName();

    void setCustomName(String customName);

    boolean isCustomNameVisible();

    void setCustomNameVisible(boolean customNameVisible);

    boolean isSilent();

    void setSilent(boolean silent);

    UUID getUniqueId();

    EntityType getEntityType();




    /*

    public Set<Player> getViewers() {
            return viewers;
        }


    public void addViewer(Player player) {
        EntitySeeEvent entitySeeEvent = new EntitySeeEvent(this, player);
        EnderFrame.get().getEnderFrameEventBus().publish(entitySeeEvent);
        if (!entitySeeEvent.isCancelled()) {
            EnderFrameSession enderFrameSession = player.getEnderFrameSessionHandler().getEnderFrameSession();
            enderFrameSession.sendEntity(this);
            this.getViewers().add(player);
        }
    }

    public void removeViewer(Player player) {
        EntityUnseeEvent entityUnseeEvent = new EntityUnseeEvent(this, player);
        EnderFrame.get().getEnderFrameEventBus().publish(entityUnseeEvent);
        if (!entityUnseeEvent.isCancelled()) {
            player.getEnderFrameSessionHandler().getEnderFrameSession().removeEntities(this);
            this.getViewers().remove(player);
        }

    }


    public abstract void tick();

     */

}
