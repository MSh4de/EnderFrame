package eu.mshade.enderframe.world.chunk;

@FunctionalInterface
public interface ChunkGenerator {

    void generate(Chunk chunk);

}
