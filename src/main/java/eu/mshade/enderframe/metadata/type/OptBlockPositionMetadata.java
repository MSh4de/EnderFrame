package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.world.Vector;

public class OptBlockPositionMetadata extends BlockPositionMetadata {

    public OptBlockPositionMetadata(Vector blockPosition) {
        super(blockPosition);
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.OPT_BLOCK_POSITION;
    }
}
