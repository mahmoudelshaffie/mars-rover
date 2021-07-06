package org.newstore.rover.commands;

import static org.newstore.rover.commands.CommandMoveTest.target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Direction;

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
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.SOUTH;

		// Expected
		int expectLongtitudedIncreasedByOne = 1;

		target(moveBackward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(currentLatitude, expectLongtitudedIncreasedByOne, currentDirection)
			.test();
	}

	@Test
	public void testMoveBackwardInEastDirectionAfterInitializationPositionShouldLatitudeDecreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.EAST;

		// Expected
		int expectLatitudeDecreasedByOne = -1;

		target(moveBackward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(expectLatitudeDecreasedByOne, currentLongtitude, currentDirection)
			.test();
	}

	@Test
	public void testMoveBackwardInWestDirectionAfterInitializationPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int currentLatitude = 0;
		int currentLongtitude = 0;
		Direction currentDirection = Direction.WEST;

		// Expected
		int expectLatitudeIncreasedByOne = 1;

		target(moveBackward)
			.given(currentLatitude, currentLongtitude, currentDirection)
			.expect(expectLatitudeIncreasedByOne, currentLongtitude, currentDirection)
			.test();
	}
}
