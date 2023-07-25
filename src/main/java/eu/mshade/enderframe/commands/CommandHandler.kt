package eu.mshade.enderframe.commands

import eu.mshade.enderframe.mojang.chat.TextComponent

private val COMMANDS = mutableMapOf<String, Command>()

data class Command(val name: String, val description: String, val executor: (CommandContext) -> Unit)
data class CommandContext(val command: Command, val args: Array<String>, val sender: CommandSender) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommandContext

        if (command != other.command) return false
        if (!args.contentEquals(other.args)) return false
        return sender == other.sender
    }

    override fun hashCode(): Int {
        var result = command.hashCode()
        result = 31 * result + args.contentHashCode()
        result = 31 * result + sender.hashCode()
        return result
    }
}

interface CommandSender {

    val senderName: String

    fun sendMessage(text: TextComponent)

    fun sendMessage(message: String) {
        sendMessage(TextComponent.of(message))
    }

}
class CommandManager {

        fun registerCommand(command: Command) {
            COMMANDS[command.name] = command
        }

        fun getCommand(command: String) = COMMANDS[command]
        fun executeCommand(command: String, commandContext: CommandContext) {
            COMMANDS[command]?.executor?.invoke(commandContext)
        }
}

