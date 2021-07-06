package org.newstore.rover.commands;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class CommandMoveTest {

	private Command target;
	private Position currentPosition;
	private Position expectedPosition;
	
	public CommandMoveTest(Command target) {
		this.target = target;
	}
	
	public CommandMoveTest given(int currentLatitude, int currentLongtitude, Direction currentDirection) {
		return given(new Position(currentLatitude, currentLongtitude, currentDirection));
	}
	
	public CommandMoveTest given(Position currentPosition) {
		this.currentPosition = currentPosition;
		return this;
	}
	
	public CommandMoveTest expect(int currentLatitude, int currentLongtitude, Direction currentDirection) {
		return expect(new Position(currentLatitude, currentLongtitude, currentDirection));
	}
	
	public CommandMoveTest expect(Position expectedPosition) {
		this.expectedPosition = expectedPosition;
		return this;
	}
	
	public void test() {
		Position actual = target.move(currentPosition);
		assertPositionCoordinatesAndDirection(expectedPosition, actual);
	}
	
	public static CommandMoveTest target(Command target) {
		return new CommandMoveTest(target);
	}
	
}
