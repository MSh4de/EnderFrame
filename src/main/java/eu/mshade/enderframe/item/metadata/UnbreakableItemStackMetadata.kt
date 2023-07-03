package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class UnbreakableItemStackMetadata(metadataValue: Boolean) :
    MetadataKeyValue<Boolean>(ItemStackMetadataKey.UNBREAKABLE, metadataValue)
