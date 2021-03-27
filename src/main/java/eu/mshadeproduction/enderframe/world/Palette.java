package eu.mshadeproduction.enderframe.world;

import java.util.Queue;
import java.util.concurrent.ConcurrentMap;

public interface Palette {

    void addBlock(int id, Block block);

    void addBlock(int x, int y, int z, Block block);

    int getPalette(Block block);

    Queue<Block> getBlocks();

    ConcurrentMap<Integer, Block> getPalettes();

}
