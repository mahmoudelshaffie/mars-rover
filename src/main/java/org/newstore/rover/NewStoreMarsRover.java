package org.newstore.rover;

import java.util.HashMap;
import java.util.Map;

import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.CommandRegistery;
import org.newstore.rover.commands.exceptions.InvalidCommandException;

public class NewStoreMarsRover implements Rover {

	private Position current;
	private CommandRegistery commandRegistery;
	private Map<Integer, Integer> obstacles;
	
	public NewStoreMarsRover(Position current, CommandRegistery commandRegistery, Map<Integer, Integer> obstacles) {
		this.current = current;
		this.commandRegistery = commandRegistery;
		this.obstacles = new HashMap<>(obstacles);
	}

	@Override
	public Position move(String command) {
		char[] moves = command.toCharArray();
		validateCommand(moves);
		for (char move : moves) {
			Position newPosition = move(move);
			if (isObstacle(newPosition)) {
				current = current.stopped();
				break;
			} else {
				current = newPosition;
			}
			
		}
		return current;
	}
	
	public Position getPosition() {
		return current;
	}
	
	private Position move(char move) {
		Command command = commandRegistery.getCommand(move).get();
		return command.move(current);
	}
	
	private boolean isObstacle(Position newPosition) {
		return obstacles.containsKey(newPosition.getLatitude()) && obstacles.get(newPosition.getLatitude()).equals(newPosition.getLongtitude());
	}
	
	private void validateCommand(char[] moves) {
		for (char move : moves) {
			if (commandRegistery.getCommand(move).isEmpty()) {
				throw new InvalidCommandException(move);
			}
		}
	}
}
