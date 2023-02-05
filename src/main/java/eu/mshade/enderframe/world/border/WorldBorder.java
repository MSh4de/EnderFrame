package eu.mshade.enderframe.world.border;

import eu.mshade.enderframe.Agent;
import eu.mshade.enderframe.Watchable;
import eu.mshade.enderframe.entity.Player;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public class WorldBorder implements Watchable {

    protected WorldBorderCenter worldBorderCenter;
    protected double oldRadius;
    protected double radius;
    protected long speed;
    protected int portalTeleportLimit;
    protected int warningTime;
    protected int warningBlocks;

    protected Queue<Agent> agents = new ConcurrentLinkedQueue<>();

    public void createWorldBorder(Player player) {
        agents.add(player);
        player.getMinecraftSession().sendWorldBorder(WorldBorderAction.INITIALIZE, this);
    }

    private void updateWorldBorder() {
        for (Agent agent : this.getWatchers()) {
            if (agent instanceof Player player) {
                player.getMinecraftSession().sendWorldBorder(WorldBorderAction.SET_SIZE, this);
            }
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

    @Override
    public void addWatcher(Agent agent) {
        agents.add(agent);
    }

    @Override
    public void removeWatcher(Agent agent) {
        agents.remove(agent);
    }

    @Override
    public Collection<Agent> getWatchers() {
        return agents;
    }

    @Override
    public boolean isWatching(Agent agent) {
        return agents.contains(agent);
    }

    @Override
    public void notify(Consumer<Agent> sessionWrapperConsumer) {
        for (Agent agent : agents) {
            sessionWrapperConsumer.accept(agent);
        }
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
                ", agents=" + agents +
                '}';
    }
}
