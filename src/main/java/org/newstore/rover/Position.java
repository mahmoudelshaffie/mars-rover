package org.newstore.rover;

public class Position {
	private int latitude;
	private int longtitude;
	private Direction direction;

	public Position(int latitude, int longtitude, Direction direction) {
		this();
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.direction = direction;
	}

	public Position() {
		this.latitude = 0;
		this.longtitude = 0;
		this.direction = Direction.NORTH;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongtitude() {
		return longtitude;
	}

	public Direction getDirection() {
		return direction;
	}
	
	public Position add(int latitudeDelta, int longtitudeDelta) {
		int newLatitude = latitude + latitudeDelta;
		int newLongtitude = longtitude + longtitudeDelta;
		return new Position(newLatitude, newLongtitude, direction);
	}
	
	public Position newDirection(Direction newDirection) {
		return new Position(latitude, longtitude, newDirection); 
	}
}
