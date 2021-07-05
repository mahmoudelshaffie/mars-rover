package org.newstore.rover;

public enum Direction {
	NORTH(0, 1), SOUTH(0, -1), EAST(1, 0), WEST(-1, 0);
	
	private int forwardLongtitudeDelta;
	private int forwardLatitudeDelta;
	
	private Direction(int forwardLongtitudeDelta, int forwardLatitudeDelta) {
		this.forwardLongtitudeDelta = forwardLongtitudeDelta;
		this.forwardLatitudeDelta = forwardLatitudeDelta;
	}
	
	public int getForwardLatitudeDelta() {
		return forwardLatitudeDelta;
	}
	
	public int getForwardLongtitudeDelta() {
		return forwardLongtitudeDelta;
	}
}
