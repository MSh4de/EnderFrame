package eu.mshade.enderframe.commands

import eu.mshade.enderframe.mojang.chat.TextComponent

interface TabCompleteContext {

    fun matches(text: String, currentArg: Int, args: Array<String>): Array<TextComponent>
}