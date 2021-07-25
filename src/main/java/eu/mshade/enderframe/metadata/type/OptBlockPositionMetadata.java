package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.world.BlockPosition;

public class OptBlockPositionMetadata extends BlockPositionMetadata {

    public OptBlockPositionMetadata(BlockPosition blockPosition) {
        super(blockPosition);
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.OPT_BLOCK_POSITION;
    }
}
