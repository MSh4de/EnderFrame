package eu.mshade.enderframe.world.chunk;

import eu.mshade.enderframe.item.Material;
import eu.mshade.enderframe.world.Dimension;

public class EmptySection extends Section {

    public EmptySection(Chunk chunk, int y) {
        super(chunk, y);
        if (chunk.getWorld().getDimension() == Dimension.OVERWORLD) {
            skyLight.fill((byte) 15);
        }

        blockLight.fill((byte) 15);
        palette.setBlock(0, 4096, Material.AIR.toBlock());
    }
}
