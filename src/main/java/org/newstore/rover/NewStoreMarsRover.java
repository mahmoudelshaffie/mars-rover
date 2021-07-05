package org.newstore.rover;

public class NewStoreMarsRover implements Rover {

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
		throw new UnsupportedOperationException("Not Supported Yet");
	}
}
