import eu.mshade.enderframe.EnderFrame
import eu.mshade.enderframe.commands.Command
import eu.mshade.enderframe.commands.CommandContext
import eu.mshade.enderframe.commands.ConsoleCommandSender
import eu.mshade.enderframe.mojang.NamespacedKey


fun main() {
    val commandManager = EnderFrame.get().commandManager

    commandManager.registerDefaultCommand(Command("test", "Test command") {
        println("Test command executed!")
    })

    commandManager.executeCommand(
        NamespacedKey.fromString("mshade:test"),
        CommandContext(commandManager.getCommand("test")!!, arrayOf(), ConsoleCommandSender)
    )
}