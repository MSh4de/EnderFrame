package eu.mshade.enderframe.metadata.world;

import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class WorldMetadataKeyValue<V> extends MetadataKeyValue<WorldMetadataType, V> {

    public WorldMetadataKeyValue(WorldMetadataType metadataKey, V metadataValue) {
        super(metadataKey, metadataValue);
    }
}
