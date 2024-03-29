package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.item.ItemStackMetadataKey;

public class UnbreakableItemStackMetadata extends MetadataKeyValue<Boolean> {

    public UnbreakableItemStackMetadata(Boolean metadataValue) {
        super(ItemStackMetadataKey.UNBREAKABLE, metadataValue);
    }
}
