package eu.mshade.enderframe.particle;

import eu.mshade.enderframe.world.Vector;

public class ParticleDust extends Particle {

    protected final float red;
    protected final float green;
    protected final float blue;
    protected final float scale;

    public ParticleDust(boolean longDistance, Vector particleVector, Vector particleOffsetVector, float particleSpeed, int particleCount, float red, float green, float blue, float scale) {
        super(ParticleType.DUST, longDistance, particleVector, particleOffsetVector, particleSpeed, particleCount);

        this.red = red;
        this.green = green;
        this.blue = blue;
        this.scale = scale;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public float getScale() {
        return scale;
    }
}
