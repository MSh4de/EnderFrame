package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.BookGeneration
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey

class BookGenerationItemStackMetadata(metadataValue: BookGeneration) :
    MetadataKeyValue<BookGeneration>(ItemStackMetadataKey.GENERATION, metadataValue) {
}