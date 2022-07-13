package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class CanDestroyItemStackMetadata extends ItemStackMetadataKeyValue<List<MaterialKey>> {

    public CanDestroyItemStackMetadata(List<MaterialKey> metadataValue) {
        super(ItemStackMetadataKey.CAN_DESTROY, metadataValue);
    }
}
