package org.newstore.rover;

public class NewStoreMarsRover implements Rover {

	private Position current;
	
	public NewStoreMarsRover(Position current) {
		this.current = current;
	}

	@Override
	public Position move(String command) {
		throw new UnsupportedOperationException("Not Supported Yet");
	}
}
