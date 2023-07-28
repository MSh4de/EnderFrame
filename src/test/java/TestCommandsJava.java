import eu.mshade.enderframe.EnderFrame;
import eu.mshade.enderframe.commands.Command;
import eu.mshade.enderframe.commands.CommandContext;
import eu.mshade.enderframe.commands.ConsoleCommandSender;
import eu.mshade.enderframe.mojang.NamespacedKey;

import java.util.function.Consumer;

public class TestCommandsJava {

    public static void main(String[] args) {
        var commandManager = EnderFrame.get().getCommandManager();
        commandManager.registerDefaultCommand(
                new Command("test", "", new String[] {}, null, (Consumer<CommandContext>) (ctx) ->
                        System.out.println("Hello World")));

        commandManager.executeCommand(NamespacedKey.fromString("mshade:test"),
                new CommandContext(commandManager.getCommand("test"), new String[]{}, ConsoleCommandSender.INSTANCE));
    }
}
