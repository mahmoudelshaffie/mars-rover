package org.newstore.rover;

import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.MoveBackward;
import org.newstore.rover.commands.MoveForward;

public class NewStoreMarsRover implements Rover {

	private final Command moveForward;
	private final Command moveBackward;
	private final char FORWARD = 'F';
	private final char BACKWARD = 'B';
	private Position current;
	
	public NewStoreMarsRover(Position current, Command moveForward, Command moveBackward) {
		this.current = current;
		this.moveForward = moveForward;
		this.moveBackward = moveBackward;
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
		Position newPosition;
		
		switch (move) {
		case FORWARD:
			newPosition = moveForward.move(current);
			break;
			
		case BACKWARD:
			newPosition = moveBackward.move(current);
			break;

		default:
			newPosition = current;
			break;
		}
		
		return newPosition;
	}
}
