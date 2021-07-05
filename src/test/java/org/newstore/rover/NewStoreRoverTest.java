package org.newstore.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class NewStoreRoverTest {
	
	@Test
	public void testMoveGivenBlankCommandWithoutAnyMovementRoverShouldSuccessfullStillInItsInitialPosition() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition);
		String blankCommand = "";
		
		// Actual
		Position actual = marsRover.move(blankCommand);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudeNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertRoverNewPosition(expectLatitudeNotChanged, expectLongtitudeNotChanged, expectDirectionNotChanged, actual);
	}

	@Test
	public void testMoveGivenOnlyForwardToTheNorthFromInitialPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition);
		String command = "F";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertRoverNewPosition(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne, expectDirectionNotChanged, actual);
	}
	
	private void assertRoverNewPosition(int expectedLatitude, int expectedLongtitude, Direction expectedDirection, Position actual) {
		assertEquals(expectedLatitude, actual.getLatitude(), "Actual latitude coordinate is not as expected");
		assertEquals(expectedLongtitude, actual.getLongtitude(), "Actual longtitude coordinate is not as expected");
		assertEquals(expectedDirection, actual.getDirection(), "Actual direction is not as expected");
	}
}
