package eu.mshade.enderframe.world;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;

public interface Section {

    int getY();

    Chunk getChunkBuffer();

    int getRealBlock();

    void setRealBlock(int realBlock);

    int[] getBlocks();

    NibbleArray getData();

    NibbleArray getBlockLight();

    NibbleArray getSkyLight();

    default MaterialKey getBlock(int index){
        int id = getBlocks()[index];
        byte data = getData().get(index);
        return MaterialKey.from(id, data, Material.getNamespacedKeyOfMaterialKey(id, data));
    }


}
