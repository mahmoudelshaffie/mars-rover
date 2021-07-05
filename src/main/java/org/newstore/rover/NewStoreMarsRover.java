package org.newstore.rover;

public class NewStoreMarsRover implements Rover {

	private final char FORWARD = 'F';	
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
			newPosition = moveForward();
			break;

		default:
			newPosition = current;
			break;
		}
		
		return newPosition;
	}
	
	
	private Position moveForward() {
		Position newPosition = current;
		if (current.getDirection() == Direction.NORTH) {
			int newLongtitude = current.getLongtitude() + 1;
			newPosition = current.newLongtitude(newLongtitude);
		} else if (current.getDirection() == Direction.SOUTH) {
			int newLongtitude = current.getLongtitude() - 1;
			newPosition = current.newLongtitude(newLongtitude);
		} else if (current.getDirection() == Direction.EAST) {
			int newLatitude = current.getLatitude() + 1;
			newPosition = current.newLatitude(newLatitude);
		} else {
			int newLatitude = current.getLatitude() - 1;
			newPosition = current.newLatitude(newLatitude);
		}
		return newPosition;
	}
}
