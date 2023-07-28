package eu.mshade.enderframe.commands

import eu.mshade.enderframe.mojang.chat.TextComponent
import org.slf4j.LoggerFactory

object ConsoleCommandSender : CommandSender {

    private val LOGGER = LoggerFactory.getLogger(ConsoleCommandSender::class.java)
    override val name: String = "CONSOLE"

    override fun sendMessage(text: TextComponent) {
        LOGGER.info(text.toLegacyText())
    }
}