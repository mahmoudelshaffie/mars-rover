package org.newstore.rover;

import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.MoveForward;

public class NewStoreMarsRover implements Rover {

	private final char FORWARD = 'F';
	private final char BACKWARD = 'B';
	private final Command moveForward = new MoveForward();
	private Position current;
	
	public NewStoreMarsRover(Position current) {
		this.current = current;
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
			newPosition = moveBackward();
			break;

		default:
			newPosition = current;
			break;
		}
		
		return newPosition;
	}
	
	private Position moveBackward() {
		int latitudeDelta = current.getDirection().getForwardLatitudeDelta() * -1;
		int longtitudeDelta = current.getDirection().getForwardLongtitudeDelta() * -1;
		return current.add(latitudeDelta, longtitudeDelta);
	}
}
