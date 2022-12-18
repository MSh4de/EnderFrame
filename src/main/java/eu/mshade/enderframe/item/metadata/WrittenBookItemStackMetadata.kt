package eu.mshade.enderframe.item.metadata

import eu.mshade.enderframe.item.WrittenBook
import eu.mshade.enderframe.metadata.MetadataKey
import eu.mshade.enderframe.metadata.MetadataKeyValue
import eu.mshade.enderframe.metadata.itemstack.ItemStackMetadataKey
import eu.mshade.enderframe.mojang.chat.TextComponent

class WrittenBookAuthorItemStackMetadata(metadataValue: TextComponent) :
    MetadataKeyValue<TextComponent>(ItemStackMetadataKey.AUTHOR, metadataValue)

class WrittenBookTitleItemStackMetadata(metadataValue: TextComponent) :
    MetadataKeyValue<TextComponent>(ItemStackMetadataKey.TITLE, metadataValue)

class WrittenBookPagesItemStackMetadata(metadataValue: List<TextComponent>) :
    MetadataKeyValue<List<TextComponent>>(ItemStackMetadataKey.PAGES, metadataValue)