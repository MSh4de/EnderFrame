package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.MaterialKey;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.item.ItemStackMetadataKey;

import java.util.List;

public class CanDestroyItemStackMetadata extends MetadataKeyValue<List<MaterialKey>> {

    public CanDestroyItemStackMetadata(List<MaterialKey> metadataValue) {
        super(ItemStackMetadataKey.CAN_DESTROY, metadataValue);
    }
}
