package eu.mshade.enderframe.world;

public interface SectionBuffer {

    int getY();

    ChunkBuffer getChunkBuffer();

    int getRealBlock();

    void setRealBlock(int realBlock);

    int[] getBlocks();

    NibbleArray getData();

    NibbleArray getBlockLight();

    NibbleArray getSkyLight();


}
