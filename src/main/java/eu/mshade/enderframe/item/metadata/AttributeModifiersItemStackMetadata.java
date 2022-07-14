package eu.mshade.enderframe.item.metadata;

import eu.mshade.enderframe.metadata.MetadataKeyValue;
import eu.mshade.enderframe.metadata.attribute.AttributeModifier;
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey;

import java.util.List;

public class AttributeModifiersItemStackMetadata extends MetadataKeyValue<List<AttributeModifier>> {

    public AttributeModifiersItemStackMetadata(List<AttributeModifier> metadataValue) {
        super(ItemStackMetadataKey.ATTRIBUTE_MODIFIERS, metadataValue);
    }
}
