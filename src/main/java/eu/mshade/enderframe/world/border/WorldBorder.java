package eu.mshade.enderframe.world.border;

import eu.mshade.enderframe.entity.Player;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

public class WorldBorder {

    protected WorldBorderCenter worldBorderCenter;
    protected double oldRadius;
    protected double radius;
    protected long speed;
    protected int portalTeleportLimit;
    protected int warningTime;
    protected int warningBlocks;
    protected Queue<Player> viewers = new ConcurrentLinkedQueue<>();

    public void createWorldBorder(Player player) {
        viewers.add(player);
        player.getSessionWrapper().sendWorldBorder(WorldBorderAction.INITIALIZE, this);
    }

    private void updateWorldBorder() {
        for (Player viewer : viewers) {
            viewer.getSessionWrapper().sendWorldBorder(WorldBorderAction.CHANGE_SIZE, this);
        }
    }

    public WorldBorderCenter getWorldBorderCenter() {
        return worldBorderCenter;
    }

    public WorldBorder setWorldBorderCenter(WorldBorderCenter worldBorderCenter) {
        this.worldBorderCenter = worldBorderCenter;
        return this;
    }

    public double getRadius() {
        return radius;
    }

    public double getOldRadius() {
        return oldRadius;
    }

    public WorldBorder setRadius(double radius) {
        this.radius = radius;
        return this;
    }

    public void modifyRadius(long speed, Function<Double, Double> radiusFunction) {
        this.oldRadius = this.radius;
        this.radius = radiusFunction.apply(radius);
        this.speed = speed;

        this.updateWorldBorder();
    }

    public long getSpeed() {
        return speed;
    }

    public int getPortalTeleportLimit() {
        return portalTeleportLimit;
    }

    public WorldBorder setPortalTeleportLimit(int portalTeleportLimit) {
        this.portalTeleportLimit = portalTeleportLimit;
        return this;
    }

    public int getWarningTime() {
        return warningTime;
    }

    public WorldBorder setWarningTime(int warningTime) {
        this.warningTime = warningTime;
        return this;
    }

    public int getWarningBlocks() {
        return warningBlocks;
    }

    public WorldBorder setWarningBlocks(int warningBlocks) {
        this.warningBlocks = warningBlocks;
        return this;
    }

    public Queue<Player> getViewers() {
        return viewers;
    }

    @Override
    public String toString() {
        return "WorldBorder{" +
                "worldBorderCenter=" + worldBorderCenter +
                ", oldRadius=" + oldRadius +
                ", radius=" + radius +
                ", speed=" + speed +
                ", portalTeleportLimit=" + portalTeleportLimit +
                ", warningTime=" + warningTime +
                ", warningBlocks=" + warningBlocks +
                ", viewers=" + viewers +
                '}';
    }
}
