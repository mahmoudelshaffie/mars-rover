package org.newstore.rover.commands;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class MoveBackwardTest {

	private MoveBackward target;
	
	@BeforeEach
	public void beforeEach() {
		target = new MoveBackward();
	}
	
	@Test
	public void testMoveBackwardFromNorthIAfterInitializationPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedDecreasedByOne = -1;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedDecreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInSouthDirectionAfterInitializationPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.SOUTH);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.SOUTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInEastDirectionAfterInitializationPositionShouldLatitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.EAST);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeDecreasedByOne = -1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.EAST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeDecreasedByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInWestDirectionAfterInitializationPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.WEST);
		
		// Actual
		Position actual = target.move(initialPosition);
		
		// Expected
		int expectLatitudeIncreasedByOne = 1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.WEST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeIncreasedByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
}
