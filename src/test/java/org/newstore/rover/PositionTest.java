package org.newstore.rover;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.Test;

public class PositionTest {

	@Test
	public void testAddGivenNumbersShouldBeAddedSuccessfullyAndRetrunNewInstance() {
		// Given
		int originalLatitude = 6;
		int originalLongtitude = 5;
		Direction originalDirection = Direction.NORTH;
		Position originalPosition = new Position(originalLatitude, originalLongtitude, originalDirection);
		
		int latitudeDelta = 3;
		int longtitudeDelta = -2;
		
		// Actual
		Position newPosition = originalPosition.add(latitudeDelta, longtitudeDelta);
		
		// Expect Original Position Not Changed
		assertPositionCoordinatesAndDirection(originalLatitude, originalLongtitude, originalDirection, originalPosition);
		
		// Expect New Position With New Coordinates
		int newLatitude = 9;
		int newLongtitude = 3;
		assertPositionCoordinatesAndDirection(newLatitude, newLongtitude, originalDirection, newPosition);
	}
}
