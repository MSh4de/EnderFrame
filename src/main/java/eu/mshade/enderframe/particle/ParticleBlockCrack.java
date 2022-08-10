package eu.mshade.enderframe.particle;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.world.Vector;

public class ParticleBlockCrack extends Particle {

    protected final MaterialKey material;
    protected final int metadata;

    public ParticleBlockCrack(boolean longDistance, Vector particleVector, Vector particleOffsetVector, float particleSpeed, int particleCount, MaterialKey material, int metadata) {
        super(ParticleType.BLOCK, longDistance, particleVector, particleOffsetVector, particleSpeed, particleCount);
        this.material = material;
        this.metadata = metadata;
    }

    public MaterialKey getMaterial() {
        return material;
    }

    public int getMetadata() {
        return metadata;
    }
}
