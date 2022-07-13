package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.ItemFlag;
import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;
import java.util.Set;

public class HideFlagsItemStackMetadata extends ItemStackMetadataKeyValue<Set<ItemFlag>> {

    public HideFlagsItemStackMetadata(Set<ItemFlag> metadataValue) {
        super(ItemStackMetadataKey.HIDE_FLAGS, metadataValue);
    }
}
