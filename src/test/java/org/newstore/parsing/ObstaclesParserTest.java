package org.newstore.parsing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class ObstaclesParserTest {

	private ObstaclesParser target = new ObstaclesParser();
	
	@Test
	public void testParseValidObstaclesShouldBeParsedSuccessfully() {
		String validObstacles = "[[1, 4], [2, 3], [5, 7]]";
		Map<Integer, Integer> actual = target.parse(validObstacles);
		int expectedNoOfObstacels = 3;
		assertEquals(expectedNoOfObstacels, actual.size());
	}
}
