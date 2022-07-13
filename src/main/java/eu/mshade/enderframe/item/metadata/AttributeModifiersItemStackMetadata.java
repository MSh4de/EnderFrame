package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.attribute.AttributeModifier;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKeyValue;

import java.util.List;

public class AttributeModifiersItemStackMetadata extends ItemStackMetadataKeyValue<List<AttributeModifier>> {

    public AttributeModifiersItemStackMetadata(List<AttributeModifier> metadataValue) {
        super(ItemStackMetadataKey.ATTRIBUTE_MODIFIERS, metadataValue);
    }
}
