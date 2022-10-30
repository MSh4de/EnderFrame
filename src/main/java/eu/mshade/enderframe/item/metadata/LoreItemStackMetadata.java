package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;

import java.util.List;

public class LoreItemStackMetadata extends MetadataKeyValue<List<String>> {

    public LoreItemStackMetadata(List<String> metadataValue) {
        super(ItemStackMetadataKey.LORE, metadataValue);
    }

}
