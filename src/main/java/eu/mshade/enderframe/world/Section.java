package eu.mshade.enderframe.world;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;

public interface Section {

    int getY();

    Chunk getChunk();

    int getRealBlock();

    void setRealBlock(int realBlock);

    int[] getBlocks();

    NibbleArray getBlockLight();

    NibbleArray getSkyLight();

    default MaterialKey getBlock(int index){
        int id = getBlocks()[index];
        return Material.fromId(id);
    }


}
