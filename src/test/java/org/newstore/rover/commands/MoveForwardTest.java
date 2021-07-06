package org.newstore.rover.commands;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class MoveForwardTest {
	
	private MoveForward target;
	
	@BeforeEach
	public void beforeEach() {
		target = new MoveForward();
	}

	@Test
	public void testMoveGivenOnlyForwardToTheNorthFromInitialPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
				
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToTheSouthFromInitialPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.SOUTH);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedDecreasedByOne = -1;
		Direction expectDirectionNotChanged = Direction.SOUTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedDecreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToEastFromInitialPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.EAST);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeIncreaseByOne = 1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.EAST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeIncreaseByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToWestFromInitialPositionShouldLatitudedDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.WEST);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeDecreaseByOne = -1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.WEST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeDecreaseByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
}
