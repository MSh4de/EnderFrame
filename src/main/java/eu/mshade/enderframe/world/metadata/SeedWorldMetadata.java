package eu.mshade.enderframe.world.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.world.WorldMetadataType;

public class SeedWorldMetadata extends MetadataKeyValue<Long> {

    public SeedWorldMetadata(Long metadataValue) {
        super(WorldMetadataType.SEED, metadataValue);
    }
}
