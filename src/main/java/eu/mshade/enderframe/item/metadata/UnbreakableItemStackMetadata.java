package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

public class UnbreakableItemStackMetadata extends ItemStackMetadataKeyValue<Boolean> {

    public UnbreakableItemStackMetadata(Boolean metadataValue) {
        super(ItemStackMetadataKey.UNBREAKABLE, metadataValue);
    }
}
