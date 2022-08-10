package eu.mshade.enderframe.particle;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.world.Vector;

public class ParticleBlockDust extends Particle {

    protected final MaterialKey material;

    public ParticleBlockDust(boolean longDistance, Vector particleVector, Vector particleOffsetVector, float particleSpeed, int particleCount, MaterialKey material) {
        super(ParticleType.BLOCK, longDistance, particleVector, particleOffsetVector, particleSpeed, particleCount);
        this.material = material;
    }

    public MaterialKey getMaterial() {
        return material;
    }
}
