package org.newstore.rover.commands;

import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class RotateToLeft implements Command {

	@Override
	public Position move(Position current) {
		Direction currentDirection = current.getDirection();
		Direction newDirection;
		
		switch (currentDirection) {
		case NORTH:
			newDirection = Direction.WEST;
			break;

		default:
			newDirection = currentDirection;
			break;
		}
		
		return current.newDirection(newDirection);
	}

}
