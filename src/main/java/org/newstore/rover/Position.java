package org.newstore.rover;

public class Position {
	private int latitude;
	private int longtitude;
	private Direction direction;
	private boolean stopped;
	
	public Position(int latitude, int longtitude, Direction direction, boolean stopped) {
		this(latitude, longtitude, direction);
		this.stopped = stopped;
	}

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
		this.stopped = false;
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
	
	public Position stopped() {
		return new Position(latitude, longtitude, direction, true);
	}
	
  public boolean isStopped() {
		return stopped;
	}
	
	@Override
	public String toString() {
		String collision = isStopped() ? " STOPPED" : "";
		return String.format("(%1$s, %2$s) %3$s%4$s", latitude, longtitude, direction, collision);
	}
}
