package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey

class BookResolvedItemStackMetadata(metadataValue: Boolean) :
    MetadataKeyValue<Boolean>(ItemStackMetadataKey.RESOLVED, metadataValue) {
}