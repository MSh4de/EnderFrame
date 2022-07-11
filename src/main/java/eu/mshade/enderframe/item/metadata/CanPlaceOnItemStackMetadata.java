package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class CanPlaceOnItemStackMetadata extends ItemStackMetadataKeyValue<List<MaterialKey>> {

    public CanPlaceOnItemStackMetadata(List<MaterialKey> metadataValue) {
        super(ItemStackMetadataKey.CAN_PLACE_ON, metadataValue);
    }
}
