package eu.mshade.enderframe.commands

import eu.mshade.enderframe.mojang.chat.TextComponent
import org.slf4j.LoggerFactory

class ConsoleCommandSender : CommandSender {

    private val LOGGER = LoggerFactory.getLogger(ConsoleCommandSender::class.java)
    override val senderName: String
        get() = "CONSOLE"

    override fun sendMessage(text: TextComponent) {
        LOGGER.info(text.toLegacyText())
    }
}