package org.newstore.rover.commands;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;
import static org.newstore.rover.commands.CommandMoveTest.target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class MoveBackwardTest {

	private MoveBackward moveBackward;

	@BeforeEach
	public void beforeEach() {
		moveBackward = new MoveBackward();
	}

	@Test
	public void testMoveBackwardFromNorthIAfterInitializationPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.NORTH;

		// Expected
		int expectLongtitudedDecreasedByOne = -1;

		target(moveBackward)
				.given(currentLatitude, currentLongtitude, currentDirection)
				.expect(currentLatitude, expectLongtitudedDecreasedByOne, currentDirection)
				.test();
	}

	@Test
	public void testMoveBackwardInSouthDirectionAfterInitializationPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.SOUTH);

		// Actual
		Position actual = moveBackward.move(initialPosition);

		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.SOUTH;

		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne,
				expectDirectionNotChanged, actual);
	}

	@Test
	public void testMoveBackwardInEastDirectionAfterInitializationPositionShouldLatitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.EAST);

		// Actual
		Position actual = moveBackward.move(initialPosition);

		// Expected
		int expectLatitudeDecreasedByOne = -1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.EAST;

		assertPositionCoordinatesAndDirection(expectLatitudeDecreasedByOne, expectLongtitudedNotChanged,
				expectDirectionNotChanged, actual);
	}

	@Test
	public void testMoveBackwardInWestDirectionAfterInitializationPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.WEST);

		// Actual
		Position actual = moveBackward.move(initialPosition);

		// Expected
		int expectLatitudeIncreasedByOne = 1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.WEST;

		assertPositionCoordinatesAndDirection(expectLatitudeIncreasedByOne, expectLongtitudedNotChanged,
				expectDirectionNotChanged, actual);
	}
}
