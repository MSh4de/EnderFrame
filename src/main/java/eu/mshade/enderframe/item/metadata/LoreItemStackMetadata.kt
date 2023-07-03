package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.mojang.chat.TextComponent

class LoreItemStackMetadata(metadataValue: MutableList<TextComponent>) :
    MetadataKeyValue<MutableList<TextComponent>>(ItemStackMetadataKey.LORE, metadataValue)
