package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.world.BlockPosition;

public class BlockPositionMetadata implements Metadata<BlockPosition> {

    private final BlockPosition blockPosition;

    public BlockPositionMetadata(BlockPosition blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public BlockPosition get() {
        return blockPosition;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.BLOCK_POSITION;
    }
}
