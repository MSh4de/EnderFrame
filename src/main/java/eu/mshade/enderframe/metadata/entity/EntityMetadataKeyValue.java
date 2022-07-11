package eu.mshade.enderframe.metadata.entity;

import eu.mshade.enderframe.metadata.MetadataKeyValue;

public class EntityMetadataKeyValue<V> extends MetadataKeyValue<EntityMetadataKey, V> {

    public EntityMetadataKeyValue(EntityMetadataKey metadataKey, V metadataValue) {
        super(metadataKey, metadataValue);
    }

}
