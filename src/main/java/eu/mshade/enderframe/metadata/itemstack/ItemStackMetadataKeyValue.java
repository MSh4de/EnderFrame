package eu.mshade.enderframe.metadata.itemstack;

import eu.mshade.enderframe.metadata.Metadata;
import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

public class ItemStackMetadataKeyValue<K> extends MetadataKeyValue<MetadataKey, K> {

    public ItemStackMetadataKeyValue(MetadataKey metadataKey, K metadataValue) {
        super(metadataKey, metadataValue);
    }
}
