package eu.mshade.enderframe.metadata.type;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataType;
import eu.mshade.enderframe.world.Vector;

public class BlockPositionMetadata implements Metadata<Vector> {

    private final Vector blockPosition;

    public BlockPositionMetadata(Vector blockPosition) {
        this.blockPosition = blockPosition;
    }

    @Override
    public Vector get() {
        return blockPosition;
    }

    @Override
    public MetadataType getMetadataType() {
        return MetadataType.BLOCK_POSITION;
    }
}
