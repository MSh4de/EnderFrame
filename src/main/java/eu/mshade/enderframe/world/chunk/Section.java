package eu.mshade.enderframe.world.chunk;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.world.chunk.Chunk;
import eu.mshade.enderframe.world.chunk.NibbleArray;

public abstract class Section {

    protected Chunk chunk;
    protected int y;
    protected int realBlock;
    protected int[] blocks;
    protected NibbleArray blockLight;
    protected NibbleArray skyLight;

    public Section(Chunk chunk, int y) {
        this(chunk, y, new int[4096], NibbleArray.allocate(4096), NibbleArray.allocate(4096));
    }

    public Section(Chunk chunk, int y, int[] blocks, NibbleArray blockLight, NibbleArray skyLight) {
        this.chunk = chunk;
        this.y = y;
        this.blocks = blocks;
        this.blockLight = blockLight;
        this.skyLight = skyLight;
    }

    public int getY(){
        return this.y;
    }

    public Chunk getChunk(){
        return this.chunk;
    }

    public int getRealBlock(){
        return this.realBlock;
    }

    public void setRealBlock(int realBlock){
        this.realBlock = realBlock;
    }

    public int[] getBlocks(){
        return this.blocks;
    }

    public NibbleArray getBlockLight(){
        return this.blockLight;
    }

    public NibbleArray getSkyLight(){
        return this.skyLight;
    }

    public MaterialKey getBlock(int index){
        int id = getBlocks()[index];
        return Material.fromId(id);
    }


}
