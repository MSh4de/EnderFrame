package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.ItemStackMetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.mojang.chat.TextComponent

class NameItemStackMetadata(metadataValue: TextComponent) :
    MetadataKeyValue<TextComponent?>(ItemStackMetadataKey.NAME, metadataValue) {

    constructor(name: String) : this(TextComponent.of(name))

}
