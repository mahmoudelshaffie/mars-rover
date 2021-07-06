package org.newstore.rover.commands;

import java.util.HashMap;
import java.util.Map;

import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class RotateToLeft implements Command {

	private Character commandInput = 'L';
	private Map<Direction, Direction> leftDirections;
	
	public RotateToLeft() {
		leftDirections = new HashMap<>();
		leftDirections.put(Direction.NORTH, Direction.WEST);
		leftDirections.put(Direction.WEST, Direction.SOUTH);
		leftDirections.put(Direction.SOUTH, Direction.EAST);
		leftDirections.put(Direction.EAST, Direction.NORTH);
	}
	
	@Override
	public Position move(Position current) {
		Direction currentDirection = current.getDirection();
		Direction newDirection = leftDirections.get(currentDirection);
		return current.newDirection(newDirection);
	}

	@Override
	public Character getCommandInput() {
		return commandInput;
	}

}
