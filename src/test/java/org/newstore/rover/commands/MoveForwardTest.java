package org.newstore.rover.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.newstore.rover.commands.CommandMoveTest.target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;

public class MoveForwardTest {
	
	private MoveForward moveForward;
	
	@BeforeEach
	public void beforeEach() {
		moveForward = new MoveForward();
	}

	@Test
	public void testMoveGivenOnlyForwardToTheNorthFromInitialPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.NORTH;

		// Expected
		int expectLongtitudedIncreasedByOne = 1;

		target(moveForward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, expectLongtitudedIncreasedByOne, currentDirection)
			.test();
	}
	
	@Test
	public void testMoveGivenOnlyForwardToTheSouthFromInitialPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.SOUTH;

		// Expected
		int expectLongtitudedDecreasedByOne = -1;

		target(moveForward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, expectLongtitudedDecreasedByOne, currentDirection)
			.test();
	}
	
	@Test
	public void testMoveGivenOnlyForwardToEastFromInitialPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.EAST;

		// Expected
		int expectLatitudeIncreaseByOne = 1;

		target(moveForward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(expectLatitudeIncreaseByOne, currentLongtitude, currentDirection)
			.test();
	}
	
	@Test
	public void testMoveGivenOnlyForwardToWestFromInitialPositionShouldLatitudedDecreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.WEST;

		// Expected
		int expectLatitudeDecreaseByOne = -1;

		target(moveForward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(expectLatitudeDecreaseByOne, currentLongtitude, currentDirection)
			.test();
	}
	
	@Test
	public void testGetCommandInputExpectForward() {
		Character expectLeft = 'F';
		assertEquals(expectLeft, moveForward.getCommandInput());
	}
}
