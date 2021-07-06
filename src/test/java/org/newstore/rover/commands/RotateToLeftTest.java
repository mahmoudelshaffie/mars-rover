package org.newstore.rover.commands;

import static org.newstore.rover.commands.CommandMoveTest.target;

import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;

public class RotateToLeftTest {
	
	private RotateToLeft rotateToLeft = new RotateToLeft();

	@Test
	public void testRotateToLeftFromNorthShouldBeAtTheSameCooardinatesButRotatedToTheWestSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.NORTH;

		// Expected
		Direction expectedRotateToWest = Direction.WEST;

		target(rotateToLeft)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToWest)
			.test();
	}
	
	@Test
	public void testRotateToLeftFromWestShouldBeAtTheSameCooardinatesButRotatedToTheSouthSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.WEST;

		// Expected
		Direction expectedRotateToSouth = Direction.SOUTH;

		target(rotateToLeft)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToSouth)
			.test();
	}
	
	@Test
	public void testRotateToLeftFromSouthShouldBeAtTheSameCooardinatesButRotatedToTheEastSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.SOUTH;

		// Expected
		Direction expectedRotateToEast = Direction.EAST;

		target(rotateToLeft)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToEast)
			.test();
	}
}
