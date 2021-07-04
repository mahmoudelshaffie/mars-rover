package org.newstore.parsing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.parsing.exceptions.InvalidPositionInputException;
import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class PositionParserTest {

	private PositionParser target;
	
	@BeforeEach
	public void beforeEach() {
		target = new PositionParser();
	}
	
	@Test
	public void testParseGivenBlankInputShouldBeSuccessfullyParsed() {
		// Given
		String blankInput = "";
		
		// Actual
		Position actual = target.parse(blankInput);
		
		//Expect
		assertNotNull(actual, "Expect position to be initialized with initial values successfully");
	}
	
	@Test
	public void testParseGivenValidInputShouldBeSuccessfullyParsedAndInitializedWithInputValues() {
		// Given
		String validInput = "(6, 9) NORTH";
		
		// Actual
		Position actual = target.parse(validInput);
		
		// Expect
		final int expectedLatitude = 6;
		final int expectedLongtitude = 9;
		final Direction expectedDirection = Direction.NORTH;
		
		assertPositionIsParsedAsExpected(expectedLatitude, expectedLongtitude, expectedDirection, actual);
	}
	
	private void assertPositionIsParsedAsExpected(int expectedLatitude, int expectedLongtitude, Direction expectedDirection, Position actual) {
		assertEquals(expectedLatitude, actual.getLatitude(), "Parsed value of position's latitude is not as expected");
		assertEquals(expectedLongtitude, actual.getLongtitude(), "Parsed value of position's longtitude is not as expected");
		assertEquals(expectedDirection, actual.getDirection(), "Parsed value of position's direction is not as expected");
	}
	
	@Test
	public void testParseGivenInValidInputWithoutOpenBracketForCoordinatesShouldFailWithInvalidPositionInputException() {
		// Given
		String inValidInputWithoutOpenBracket = "6, 9) NORTH";
		
		// Actual
		assertThrows(InvalidPositionInputException.class, () -> target.parse(inValidInputWithoutOpenBracket));
	}
	
	@Test
	public void testParseGivenInValidInputWithoutCommaSeparatorForCoordinatesShouldFailWithInvalidPositionInputException() {
		// Given
		String inValidInputWithoutCommaSeparator = "(6 9) NORTH";
		
		// Actual
		assertThrows(InvalidPositionInputException.class, () -> target.parse(inValidInputWithoutCommaSeparator));
	}
	
	@Test
	public void testParseGivenInValidInputWithoutClosedBrackedForCoordinatesShouldFailWithInvalidPositionInputException() {
		// Given
		String inValidInputWithoutCommaSeparator = "(6, 9 NORTH";
		
		// Actual
		assertThrows(InvalidPositionInputException.class, () -> target.parse(inValidInputWithoutCommaSeparator));
	}
	
	@Test
	public void testParseGivenInValidInputWithInvalidDirectionShouldFailWithInvalidPositionInputException() {
		// Given
		String inValidInputWithoutCommaSeparator = "(6, 9) NOR";
		
		// Actual
		assertThrows(InvalidPositionInputException.class, () -> target.parse(inValidInputWithoutCommaSeparator));
	}
	
	@Test
	public void testParseGivenInValidInputWithoutDirectionShouldFailWithInvalidPositionInputException() {
		// Given
		String inValidInputWithoutDirection = "(6, 9)";
		
		// Actual
		assertThrows(InvalidPositionInputException.class, () -> target.parse(inValidInputWithoutDirection));
	}
}
