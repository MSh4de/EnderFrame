package eu.mshade.enderframe.particle;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.world.Vector;

public class Particle {

    protected final ParticleKey particleKey;
    protected final boolean longDistance;
    protected final Vector particleVector;
    protected final Vector particleOffsetVector;
    protected final float particleSpeed;
    protected final int particleCount;

    public Particle(ParticleKey particleKey, boolean longDistance, Vector particleVector, Vector particleOffsetVector, float particleSpeed, int particleCount) {
        this.particleKey = particleKey;
        this.longDistance = longDistance;
        this.particleVector = particleVector;
        this.particleOffsetVector = particleOffsetVector;
        this.particleSpeed = particleSpeed;
        this.particleCount = particleCount;
    }

    public void showParticle(Player player) {
        player.getSessionWrapper().sendParticle(this);
    }

    public ParticleKey getParticleKey() {
        return particleKey;
    }

    public boolean isLongDistance() {
        return longDistance;
    }

    public Vector getParticleVector() {
        return particleVector;
    }

    public Vector getParticleOffsetVector() {
        return particleOffsetVector;
    }

    public float getParticleSpeed() {
        return particleSpeed;
    }

    public int getParticleCount() {
        return particleCount;
    }
}
