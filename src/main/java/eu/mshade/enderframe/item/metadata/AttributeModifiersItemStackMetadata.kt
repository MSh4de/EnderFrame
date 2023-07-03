package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackAttributeModifier
import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class AttributeModifiersItemStackMetadata(metadataValue: MutableList<ItemStackAttributeModifier>) :
    MetadataKeyValue<MutableList<ItemStackAttributeModifier>>(ItemStackMetadataKey.ATTRIBUTE_MODIFIERS, metadataValue)
