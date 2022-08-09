package eu.mshade.enderframe.world;

@FunctionalInterface
public interface ChunkGenerator {

    void generate(Chunk chunk);

}
