package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.mojang.Color

class ColorItemStackMetadata(metadataValue: Color) :
    MetadataKeyValue<Color>(ItemStackMetadataKey.COLOR, metadataValue)
