package eu.mshade.enderframe.commands

import eu.mshade.enderframe.mojang.NamespacedKey
import eu.mshade.enderframe.mojang.chat.TextComponent
import eu.mshade.enderframe.plugin.Plugin
import java.util.*
import java.util.function.Consumer

data class Command(
    val name: String,
    val description: String? = null,
    val alias: Array<String> = arrayOf(),
    val tabComplete: TabCompleteContext? = null,
    val executor: Consumer<CommandContext>
) {
    internal lateinit var namespacedKey: NamespacedKey

    constructor(
        name: String,
        description: String? = null,
        alias: Array<String> = arrayOf(),
        tabComplete: TabCompleteContext? = null,
        executor: CommandExecutor
    ) : this(name, description, alias, tabComplete, Consumer { executor.onCommand(it) })

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Command

        if (name != other.name) return false
        if (description != other.description) return false
        if (!alias.contentEquals(other.alias)) return false
        if (tabComplete != other.tabComplete) return false
        return executor == other.executor
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + alias.contentHashCode()
        result = 31 * result + (tabComplete?.hashCode() ?: 0)
        result = 31 * result + executor.hashCode()
        return result
    }

    override fun toString(): String =
        "Command(name='$name', description=$description, alias=${alias.contentToString()})"

}

data class CommandContext(val command: Command, val args: Array<String>, val sender: CommandSender) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommandContext

        if (command != other.command) return false
        if (!args.contentEquals(other.args)) return false
        return sender == other.sender
    }

    override fun hashCode(): Int = Objects.hash(command, args, sender)
}

interface CommandExecutor {
    fun onCommand(ctx: CommandContext)

}

interface CommandSender {

    val name: String?
        get() = "UNKNOWN"

    fun sendMessage(text: TextComponent)

    fun sendMessage(message: String) {
        sendMessage(TextComponent.of(message))
    }

}

class CommandManager {

    private val COMMANDS = mutableMapOf<NamespacedKey, Command>()

    fun registerDefaultCommand(command: Command) {
        command.namespacedKey = NamespacedKey(NamespacedKey.MSHADE, command.name)
        registerCommand(command, command.namespacedKey)
    }

    fun registerCommand(command: Command, plugin: Class<out Plugin>) {
        command.namespacedKey = NamespacedKey(plugin.name.lowercase(), command.name)
        registerCommand(command, command.namespacedKey)
    }

    private fun registerCommand(command: Command, key: NamespacedKey) {
        if(COMMANDS.containsKey(key))
            throw IllegalArgumentException("Command ${command.namespacedKey} already registered!")
        COMMANDS[command.namespacedKey] = command
    }

    fun getCommand(command: String) = getCommand(COMMANDS.keys.firstOrNull { it.key == command })
    fun getCommand(command: NamespacedKey?) = COMMANDS[command]
    fun getCommands() = COMMANDS.toMap()
    fun executeCommand(command: NamespacedKey, commandContext: CommandContext) {
        COMMANDS[command]?.executor?.accept(commandContext)
    }
}

