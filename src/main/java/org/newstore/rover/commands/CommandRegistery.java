package org.newstore.rover.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistery {

	private Map<Character, Command> commands;
	
	public CommandRegistery(Command...commandsToRegister) {
		commands = new HashMap<>();
		for (Command command : commandsToRegister) {
			commands.put(command.getCommandInput(), command);
		}
	}
	
	public Optional<Command> getCommand(Character commandInput) {
		return Optional.ofNullable(commands.get(commandInput));
	}
	
	public static CommandRegistery register(Command...commandsToRegister) {
		return new CommandRegistery(commandsToRegister);
	}
}
