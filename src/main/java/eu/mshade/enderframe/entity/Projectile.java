package eu.mshade.enderframe.entity;

public interface Projectile {

    ProjectileSource getShooter();

    void setShooter(ProjectileSource source);

    boolean doesBounce();

    void setBounce(boolean var1);
}
