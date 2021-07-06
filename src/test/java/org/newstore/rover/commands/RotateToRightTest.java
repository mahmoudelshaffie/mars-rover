package org.newstore.rover.commands;

import static org.newstore.rover.commands.CommandMoveTest.target;

import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;

public class RotateToRightTest {

	private RotateToRight rotateToRight = new RotateToRight();

	@Test
	public void testRotateToRightFromNorthShouldBeAtTheSameCooardinatesButRotatedToTheEastSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.NORTH;

		// Expected
		Direction expectedRotateToWest = Direction.EAST;

		target(rotateToRight)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToWest)
			.test();
	}
}
