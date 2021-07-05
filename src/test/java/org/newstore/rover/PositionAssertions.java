package org.newstore.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionAssertions {

	public static void assertPositionCoordinatesAndDirection(int expectedLatitude, int expectedLongtitude, Direction expectedDirection, Position actual) {
		assertEquals(expectedLatitude, actual.getLatitude(), "Actual latitude coordinate is not as expected");
		assertEquals(expectedLongtitude, actual.getLongtitude(), "Actual longtitude coordinate is not as expected");
		assertEquals(expectedDirection, actual.getDirection(), "Actual direction is not as expected");
	}
}
