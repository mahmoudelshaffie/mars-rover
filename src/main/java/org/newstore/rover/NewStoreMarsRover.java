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
		
		Position lastPosition = current;
		
		for (char move : moves) {
			Position newPosition = move(move, lastPosition);
			if (isObstacle(newPosition)) {
				lastPosition = lastPosition.stopped();
				break;
			} else {
				lastPosition = newPosition;
			}
		}
		
		current = lastPosition;
		return current;
	}
	
	@Override
	public Position getPosition() {
		return current;
	}
	
	private Position move(char move, Position from) {
		Command command = commandRegistery
								.getCommand(move)
								.orElseThrow(() -> new InvalidCommandException(move));
		
		return command.move(from);
	}
	
	private boolean isObstacle(Position newPosition) {
		return obstacles.containsKey(newPosition.getLatitude()) 
				&& obstacles.get(newPosition.getLatitude()).equals(newPosition.getLongtitude());
	}
}
