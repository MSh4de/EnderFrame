package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;

import java.util.List;

public class CanPlaceOnItemStackMetadata extends MetadataKeyValue<List<MaterialKey>> {

    public CanPlaceOnItemStackMetadata(List<MaterialKey> metadataValue) {
        super(ItemStackMetadataKey.CAN_PLACE_ON, metadataValue);
    }
}
