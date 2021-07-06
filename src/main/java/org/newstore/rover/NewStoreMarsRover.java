package org.newstore.rover;

public class NewStoreMarsRover implements Rover {

	private final char FORWARD = 'F';
	private final char BACKWARD = 'B';
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
			
		case BACKWARD:
			newPosition = moveBackward();
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
	
	private Position moveBackward() {
		int latitudeDelta = current.getDirection().getForwardLatitudeDelta() * -1;
		int longtitudeDelta = current.getDirection().getForwardLongtitudeDelta() * -1;
		return current.add(latitudeDelta, longtitudeDelta);
	}
}
