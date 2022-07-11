package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.attribute.AttributeModifier;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class AttributeModifiersItemStackMetadata extends ItemStackMetadataKeyValue<List<AttributeModifier>> {
    public AttributeModifiersItemStackMetadata(ItemStackMetadataKey metadataKey, List<AttributeModifier> metadataValue) {
        super(metadataKey, metadataValue);
    }
}
