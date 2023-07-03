package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemFlag
import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue

class HideFlagsItemStackMetadata(metadataValue: Set<ItemFlag>) :
    MetadataKeyValue<Set<ItemFlag>>(ItemStackMetadataKey.HIDE_FLAGS, metadataValue)
