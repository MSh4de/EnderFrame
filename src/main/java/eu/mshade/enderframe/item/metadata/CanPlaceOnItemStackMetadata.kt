package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.item.MaterialKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class CanPlaceOnItemStackMetadata(metadataValue: MutableSet<MaterialKey>) :
    MetadataKeyValue<MutableSet<MaterialKey>>(ItemStackMetadataKey.CAN_PLACE_ON, metadataValue)
