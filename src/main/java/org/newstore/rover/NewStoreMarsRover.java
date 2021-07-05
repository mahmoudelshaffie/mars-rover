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
		int latitudeDelta = current.getDirection().getForwardLatitudeDelta();
		int longtitudeDelta = current.getDirection().getForwardLongtitudeDelta();
		return current.add(latitudeDelta, longtitudeDelta);
	}
}
