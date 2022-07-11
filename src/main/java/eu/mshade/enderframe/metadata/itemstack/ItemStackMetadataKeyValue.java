package eu.mshade.enderframe.metadata.itemstack;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.MetadataKeyValueBucket;

public class ItemStackMetadataKeyValue<K> extends MetadataKeyValue<ItemStackMetadataKey, K> {

    public ItemStackMetadataKeyValue(ItemStackMetadataKey metadataKey, K metadataValue) {
        super(metadataKey, metadataValue);
    }
}
