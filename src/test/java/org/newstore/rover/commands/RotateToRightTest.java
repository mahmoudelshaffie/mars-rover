package org.newstore.rover.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@Test
	public void testRotateToRightFromEastShouldBeAtTheSameCooardinatesButRotatedToTheSouthSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.EAST;

		// Expected
		Direction expectedRotateToWest = Direction.SOUTH;

		target(rotateToRight)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToWest)
			.test();
	}
	
	@Test
	public void testRotateToRightFromSouthShouldBeAtTheSameCooardinatesButRotatedToTheWestSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.SOUTH;

		// Expected
		Direction expectedRotateToWest = Direction.WEST;

		target(rotateToRight)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToWest)
			.test();
	}
	
	@Test
	public void testRotateToRightFromWestShouldBeAtTheSameCooardinatesButRotatedToTheNorthSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.WEST;

		// Expected
		Direction expectedRotateToWest = Direction.NORTH;

		target(rotateToRight)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, currentLongtitude, expectedRotateToWest)
			.test();
	}
	
	@Test
	public void testGetCommandInputExpectRight() {
		Character right = 'R';
		assertEquals(right, rotateToRight.getCommandInput());
	}
}
