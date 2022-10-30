package eu.mshade.enderframe.world.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.world.WorldMetadataType;
import eu.mshade.enderframe.world.Dimension;

public class DimensionWorldMetadata extends MetadataKeyValue<Dimension> {

    public DimensionWorldMetadata(Dimension metadataValue) {
        super(WorldMetadataType.DIMENSION, metadataValue);
    }
}
