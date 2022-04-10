package eu.mshade.enderframe.world;

public interface Section {

    int getY();

    Chunk getChunkBuffer();

    int getRealBlock();

    void setRealBlock(int realBlock);

    int[] getBlocks();

    NibbleArray getData();

    NibbleArray getBlockLight();

    NibbleArray getSkyLight();


}
