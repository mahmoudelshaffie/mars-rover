package org.newstore.parsing;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.Position;

public class PositionParserTest {

	private PositionParser target;
	
	@BeforeEach
	public void beforeEach() {
		target = new PositionParser();
	}
	
	@Test
	public void testParseGivenEmptyStringShouldBeSuccessfullyParsed() {
		String emptyPosition = "";
		Position actual = target.parse(emptyPosition);
		assertNotNull(actual, "Expect position to be initialized with initial values successfully");
	}
}
