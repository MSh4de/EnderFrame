package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.item.ItemStackAttributeModifier;
import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;

import java.util.List;

public class AttributeModifiersItemStackMetadata extends MetadataKeyValue<List<ItemStackAttributeModifier>> {

    public AttributeModifiersItemStackMetadata(List<ItemStackAttributeModifier> metadataValue) {
        super(ItemStackMetadataKey.ATTRIBUTE_MODIFIERS, metadataValue);
    }
}
