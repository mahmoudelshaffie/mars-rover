package org.newstore.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DirectionTest {

	private final int ZERO = 0;
	private final int ONE = 1;
	private final int NEGATIVE_ONE = -1;

	@Test
	public void testGetForwadLongtitudeDeltaOfNorthDirectionExpectOne() {
		assertEquals(ONE, Direction.NORTH.getForwardLongtitudeDelta(),
				"Expect move forward delta for longtitude coordinate of North direction to be one");
	}

	@Test
	public void testGetForwadLatitudeDeltaOfNorthDirectionExpectZero() {
		assertEquals(ZERO, Direction.NORTH.getForwardLatitudeDelta(),
				"Expect move forward delta for latitude coordinate of North direction to be zero");
	}

	@Test
	public void testGetForwadLongtitudeDeltaOfSouthDirectionExpectNegativeOne() {
		assertEquals(NEGATIVE_ONE, Direction.SOUTH.getForwardLongtitudeDelta(),
				"Expect move forward delta for longtitude coordinate of North direction to be negative one");
	}

	@Test
	public void testGetForwadLatitudeDeltaOfSouthDirectionExpectZero() {
		assertEquals(ZERO, Direction.SOUTH.getForwardLatitudeDelta(),
				"Expect move forward delta for latitude coordinate of North direction to be zero");
	}
	
	@Test
	public void testGetForwadLongtitudeDeltaOfEastDirectionExpectZero() {
		assertEquals(ZERO, Direction.EAST.getForwardLongtitudeDelta(),
				"Expect move forward delta for longtitude coordinate of North direction to be zero");
	}

	@Test
	public void testGetForwadLatitudeDeltaOfEastDirectionExpectOne() {
		assertEquals(ONE, Direction.EAST.getForwardLatitudeDelta(),
				"Expect move forward delta for latitude coordinate of North direction to be one");
	}
	
	@Test
	public void testGetForwadLongtitudeDeltaOfWestDirectionExpectZero() {
		assertEquals(ZERO, Direction.WEST.getForwardLongtitudeDelta(),
				"Expect move forward delta for longtitude coordinate of North direction to be zero");
	}

	@Test
	public void testGetForwadLatitudeDeltaOfWestDirectionExpectNegativeOne() {
		assertEquals(NEGATIVE_ONE, Direction.WEST.getForwardLatitudeDelta(),
				"Expect move forward delta for latitude coordinate of west direction to be negative one");
	}
}
