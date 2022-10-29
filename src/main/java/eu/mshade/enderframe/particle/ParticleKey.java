package eu.mshade.enderframe.particle;

public interface ParticleKey {

    String id();

    static ParticleKey fromId(String id){
        return new DefaultParticleKey(id);
    }

    record DefaultParticleKey(String id) implements ParticleKey {

    }
}
