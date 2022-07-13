package eu.mshade.enderframe.metadata.entity;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class EntityMetadataKeyValue<V> extends MetadataKeyValue<MetadataKey, V> {

    public EntityMetadataKeyValue(MetadataKey metadataKey, V metadataValue) {
        super(metadataKey, metadataValue);
    }

}
