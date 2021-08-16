package eu.mshade.enderframe.entity;

import eu.mshade.enderframe.world.Vector;

public interface ProjectileSource {

    <T extends Projectile> T launchProjectile(Class<? extends T> projectile);

    <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector vector);
}
