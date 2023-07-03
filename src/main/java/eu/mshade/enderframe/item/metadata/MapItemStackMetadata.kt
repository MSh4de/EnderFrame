package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.map.MapDecoration
import eu.mshade.enderframe.metadata.MetadataKeyValue

class MapIsScalingItemStackMetadata(metadataValue: Boolean) :
    MetadataKeyValue<Boolean>(ItemStackMetadataKey.MAP_IS_SCALING, metadataValue)

class MapDecorationsItemStackMetadata(metadataValue: MutableList<MapDecoration>) :
    MetadataKeyValue<MutableList<MapDecoration>>(ItemStackMetadataKey.MAP_DECORATIONS, metadataValue)