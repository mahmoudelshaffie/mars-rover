package org.newstore.rover;

import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.CommandRegistery;
import org.newstore.rover.commands.exceptions.InvalidCommandException;

public class NewStoreMarsRover implements Rover {

	private Position current;
	private CommandRegistery commandRegistery;
	
	public NewStoreMarsRover(Position current, CommandRegistery commandRegistery) {
		this.current = current;
		this.commandRegistery = commandRegistery;
	}

	@Override
	public Position move(String command) {
		char[] moves = command.toCharArray();
		for (char move : moves) {
			current = move(move);
		}
		return current;
	}
	
	private Position move(char move) {
		Command command = commandRegistery.getCommand(move)
											.orElseThrow(() -> new InvalidCommandException(move));
		current = command.move(current);
		return current;
	}
}
