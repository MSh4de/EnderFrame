package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.MapDecoration
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey

class MapIsScalingItemStackMetadata(metadataValue: Boolean) :
    MetadataKeyValue<Boolean>(ItemStackMetadataKey.MAP_IS_SCALING, metadataValue)

class MapDecorationsItemStackMetadata(metadataValue: List<MapDecoration>) :
    MetadataKeyValue<List<MapDecoration>>(ItemStackMetadataKey.DECORATIONS, metadataValue)