package org.newstore.rover.commands;

import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class RotateToLeft implements Command {

	private Character commandInput = 'L';

	@Override
	public Position move(Position current) {
		Direction currentDirection = current.getDirection();
		Direction newDirection;
		
		switch (currentDirection) {
		case NORTH:
			newDirection = Direction.WEST;
			break;
			
		case WEST:
			newDirection = Direction.SOUTH;
			break;

		case SOUTH:
			newDirection = Direction.EAST;
			break;
			
		case EAST:
			newDirection = Direction.NORTH;
			break;
			
		default:
			newDirection = currentDirection;
			break;
		}
		
		return current.newDirection(newDirection);
	}

	@Override
	public Character getCommandInput() {
		return commandInput;
	}

}
