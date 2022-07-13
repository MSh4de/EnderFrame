package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class LoreItemStackMetadata extends ItemStackMetadataKeyValue<List<String>> {

    public LoreItemStackMetadata(List<String> metadataValue) {
        super(ItemStackMetadataKey.LORE, metadataValue);
    }
}