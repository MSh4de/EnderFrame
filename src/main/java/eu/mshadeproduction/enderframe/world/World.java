package eu.mshadeproduction.enderframe.world;

public interface World {

    void setBlock(int x, int y, int z, Block block);

    Block getBlock(int x, int y, int z);

}
