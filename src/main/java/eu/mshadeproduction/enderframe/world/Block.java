package eu.mshadeproduction.enderframe.world;

public interface Block {

    int getType();

    int getData();

    Chunk getChunk();

    World getWorld();

}
