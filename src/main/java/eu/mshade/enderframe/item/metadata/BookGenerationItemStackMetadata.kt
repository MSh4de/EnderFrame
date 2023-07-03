package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.BookGeneration
import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class BookGenerationItemStackMetadata(metadataValue: BookGeneration) :
    MetadataKeyValue<BookGeneration>(ItemStackMetadataKey.GENERATION, metadataValue) {
}