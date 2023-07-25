import eu.mshade.enderframe.EnderFrame
import eu.mshade.enderframe.commands.Command
import eu.mshade.enderframe.commands.CommandContext
import eu.mshade.enderframe.commands.ConsoleCommandSender

fun main() {
    val commandManager = EnderFrame.get().commandManager

    commandManager.registerCommand(Command("test", "Test command") { commandContext ->
        commandContext.sender.sendMessage("Hello, ${commandContext.sender.senderName}!")
    })

    commandManager.executeCommand(
        "test",
        CommandContext(commandManager.getCommand("test")!!, arrayOf(), ConsoleCommandSender())
    )
}