package eu.mshade.enderframe.metadata.world;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class WorldMetadataKeyValue<V> extends MetadataKeyValue<MetadataKey, V> {

    public WorldMetadataKeyValue(MetadataKey metadataKey, V metadataValue) {
        super(metadataKey, metadataValue);
    }
}
