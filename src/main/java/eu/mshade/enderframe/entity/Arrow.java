package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Location;
import eu.mshade.enderframe.world.Vector;

import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public interface Arrow extends Entity, Projectile {

    /*
    private boolean isCritical;
    private ProjectileSource source;
    private boolean isBouncy;

     */

    boolean isCritical();

    void setCritical(boolean isCritical);

}
