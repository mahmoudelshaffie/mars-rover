package org.newstore.rover.commands;

import java.util.HashMap;
import java.util.Map;

import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class RotateToRight implements Command {

	private Character commandInput = 'R';
	private Map<Direction, Direction> rightDirections;
	
	public RotateToRight() {
		rightDirections = new HashMap<>();
		rightDirections.put(Direction.NORTH, Direction.EAST);
	}

	@Override
	public Position move(Position current) {
		Direction currentDirection = current.getDirection();
		Direction newDirection = rightDirections.get(currentDirection);
		return current.newDirection(newDirection);
	}

	@Override
	public Character getCommandInput() {
		return commandInput;
	}
}
