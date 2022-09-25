package eu.mshade.enderframe.world.chunk;

import eu.mshade.enderframe.UniqueId;
import eu.mshade.enderframe.world.block.Block;

public abstract class Section {

    protected Chunk chunk;
    protected int y;
    protected int realBlock;
    protected Palette palette;
    protected int[] blocks;
    protected NibbleArray blockLight;
    protected NibbleArray skyLight;
    protected UniqueId uniqueId;

    public Section(Chunk chunk, int y) {
        this(chunk, y, new Palette(), new int[4096], new UniqueId(1), NibbleArray.allocate(4096), NibbleArray.allocate(4096));
    }

    public Section(Chunk chunk, int y, Palette palette, int[] blocks, UniqueId uniqueId, NibbleArray blockLight, NibbleArray skyLight) {
        this.chunk = chunk;
        this.y = y;
        this.palette = palette;
        this.blocks = blocks;
        this.uniqueId = uniqueId;
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

    public Palette getPalette() {
        return palette;
    }

    public Block getBlock(int index){
        return palette.getBlock(blocks[index]);
    }

    public int[] getBlocks() {
        return blocks;
    }

    public UniqueId getUniqueId() {
        return uniqueId;
    }

    public NibbleArray getBlockLight(){
        return this.blockLight;
    }

    public NibbleArray getSkyLight(){
        return this.skyLight;
    }

}
