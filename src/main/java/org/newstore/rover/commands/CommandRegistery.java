package org.newstore.rover.commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandRegistery {

	private static CommandRegistery registery;
	private Map<Character, Command> commands;
	
	private CommandRegistery(Command...commandsToRegister) {
		commands = new HashMap<>();
		for (Command command : commandsToRegister) {
			commands.put(command.getCommandInput(), command);
		}
	}
	
	public Optional<Command> getCommand(Character commandInput) {
		return Optional.ofNullable(commands.get(commandInput));
	}
	
	public static CommandRegistery register(Command...commandsToRegister) {
		if (registery == null) {
			registery = new CommandRegistery(commandsToRegister);
		}
		return registery;
	}
}
