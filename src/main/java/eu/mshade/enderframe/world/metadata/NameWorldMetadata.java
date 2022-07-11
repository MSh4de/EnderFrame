package eu.mshade.enderframe.world.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.world.WorldMetadataKeyValue;
import eu.mshade.enderframe.metadata.world.WorldMetadataType;

public class NameWorldMetadata extends WorldMetadataKeyValue<String> {

    public NameWorldMetadata(String metadataValue) {
        super(WorldMetadataType.NAME, metadataValue);
    }
}
