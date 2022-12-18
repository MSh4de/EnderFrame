package eu.mshade.enderframe.item

import eu.mshade.enderframe.mojang.chat.TextComponent

data class WrittenBook(val author: TextComponent, val title: TextComponent, val pages: List<TextComponent>)